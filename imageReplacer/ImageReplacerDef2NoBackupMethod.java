

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageReplacerDef2NoBackupMethod {

        public static void main(String[] args) throws IOException, InterruptedException {
        // Carpeta donde están los GIFs
        String folderPath = "C:\\Users\\usuario\\workspace\\Repo\\optimized_images";

        // Obtener todos los archivos GIF en la carpeta
        File folder = new File(folderPath);
        File[] gifFiles = folder.listFiles((dir, name) -> name.matches("\\d{5}\\.gif")); // Buscar nombres como 00099.gif

        if (gifFiles == null || gifFiles.length == 0) {
            System.out.println("No se encontraron GIFs en la carpeta.");
            return;
        }

        // Ordenar los archivos por nombre (por si acaso)
        Arrays.sort(gifFiles);

        // Recorrer todos los GIFs encontrados
        for (File file : gifFiles) {
            String fileName = file.getName(); // Ejemplo: "00099.gif"
            int imageNumber = Integer.parseInt(fileName.substring(0, 5)); // Extraer "00099" → 99

            System.out.println("Reemplazando imagen " + imageNumber + " con " + file.getPath());

            // Llamar a replaceImage con la ruta del archivo y el número de imagen
            replaceImage(file.getPath(), imageNumber);
            Thread.sleep(1000);
        }
    }

    public static void replaceImage(String newImagePath, int imageNumber) throws IOException {
        String filePath = "nyanco.sp";
        // Pigge: 65
        // Jackie Peng: 66
        // Gory: 67
        // Baa Baa: 68
        // Sir Seal: 69
        // Le'Boin: 70
        // Kang Roo: 71
        // One Horn: 72
        // Techaer Bear: 73
        // Croco: 74
        // B.B. Bunny: 75
        // Squire Rel: 76
        // Assassin Bear: 77
        // Shy Boy: 78
        // The Face: 79
        // Mr. Sign: 82 (alredy in the game)
        // Mooth: 83

        // Cow Cat: 37
        // Bird Cat: 38
        // Fish Cat: 39
        // Lizard Cat: 40
        // Titan Cat: 41
        // Giraffe Cat: 47



        imageNumber -= 1;
        RandomAccessFile spFile = new RandomAccessFile("nyanco.sp", "r");


        // Posición donde está almacenado el número de imágenes (en tu caso, 1064)
        spFile.seek(1064);

        // Leer los dos bytes en su orden original
        int byte1 = spFile.readUnsignedByte(); // Primer byte
        int byte2 = spFile.readUnsignedByte(); // Segundo byte

        // Convertir de Little-Endian a Big-Endian (invertir los bytes)
        int numImages = (byte2 << 8) | byte1; // Revertir el orden

        numImages += 1;


        // Hay 2 + 4 + 2 + 1 + 1 + 1 bytes para asignar el número de imágenes, sonidos, etc.. en el
        // código
        spFile.seek(spFile.getFilePointer() + 11);

        int[] offsets = new int[numImages];
        int minBytesUsed = 1; // Al menos 1 byte se debe usar (para evitar offset 0)
        
        // Asumimos que offsets[0] ya está definido (o se lo asigna previamente)
        for (int i = 1; i < offsets.length; i++) {
            // El último offset (el del zip) está un poco antes que los de los gif
            if (i == 264) {
                spFile.seek(1066);
            }
        
            // En el archivo número 13, se salta un byte
            if (i == 13) {
                spFile.readUnsignedByte();
            }
        
            int previousOffset = offsets[i - 1];
            boolean validOffset = false;
            
            // Se vuelve a leer el mismo offset hasta que el valor leído sea mayor que el anterior
            while (!validOffset) {
                long startPos = spFile.getFilePointer(); // guardar posición de inicio para re-leer si es necesario
                int offset = 0;
                boolean foundNonZero = false;
                int shift = 0;
                int bytesUsed = 0;
                
                // Leer 4 bytes en orden little-endian
                for (int j = 0; j < 4; ++j) {
                    int byteValue = spFile.readUnsignedByte();
                    // Si encontramos un byte distinto de 0 o ya habíamos empezado, lo usamos para construir el número
                    if (byteValue != 0 || foundNonZero) {
                        foundNonZero = true;
                        offset += byteValue << (shift * 8);
                        shift++;
                        bytesUsed++;
                    }
                }
                
                // Si usamos menos bytes que el mínimo requerido, rellenamos con ceros a la derecha
                while (bytesUsed < minBytesUsed) {
                    offset <<= 8; // Añadimos un byte 0 a la derecha (multiplica por 256)
                    bytesUsed++;
                }
                
                // Validar que el offset leído sea mayor que el anterior
                if (offset > previousOffset) {
                    validOffset = true;
                    offsets[i] = offset;
                } else {
                    // Si no es mayor, se incrementa el mínimo de bytes usados y se vuelve a leer desde la misma posición
                    minBytesUsed++;
                    spFile.seek(startPos);
                }
            }
        }
        
        
        

        spFile.seek(2131);

        // Determinar el inicio y fin de la imagen a reemplazar
        int startOffset = offsets[imageNumber];
        int endOffset =
                (imageNumber + 1 < numImages) ? offsets[imageNumber + 1] : (int) spFile.length();


        // Leer la nueva imagen
        byte[] newImageData = readFile(newImagePath);
        int newSize = newImageData.length;
        int oldSize = endOffset - startOffset;
        int sizeDifference = newSize - oldSize;

        // Crear un nuevo archivo temporal para escribir el contenido modificado
        RandomAccessFile tempFile = new RandomAccessFile("temp.sp", "rw");

        // Copiar datos previos a la imagen
        spFile.seek(0);
        copyBytes(spFile, tempFile, (2131 + startOffset));

        // Escribir la nueva imagen
        tempFile.write(newImageData);

        // Copiar el resto del archivo
        spFile.seek(endOffset + 2131);
        copyBytes(spFile, tempFile, (int) (spFile.length() - endOffset));


        // Ajustar los offsets y escribirlos en el nuevo archivo
        tempFile.seek(1064 + 2 + 11); // Posición donde comienzan los offsets

        for (int i = 1; i < offsets.length; i++) {

            if (i > imageNumber) {
                offsets[i] += sizeDifference;
            }
            if (i != 264)
                writeOffset(tempFile, offsets[i], 4, i);
            else
                writeFinalOffset(tempFile, offsets[i], 4, i);

        }


        spFile.close();
        tempFile.close();

        // Eliminar el archivo original
        File originalFile = new File(filePath);
        originalFile.delete();

        // Renombrar el archivo temporal como el nuevo archivo principal
        File tempFileRef = new File("temp.sp");
        tempFileRef.renameTo(originalFile); // Renombrar temp.sp -> nyanco.sp


        System.out.println("Imagen " + (imageNumber + 1) + " reemplazada correctamente.");
    }

    // Función para leer un archivo en un array de bytes
    public static byte[] readFile(String path) throws IOException {
        File file = new File(path);
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        fis.close();
        return data;
    }

    // Copia una cantidad de bytes de un archivo a otro
    public static void copyBytes(RandomAccessFile source, RandomAccessFile target, int numBytes)
            throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while (numBytes > 0
                && (bytesRead = source.read(buffer, 0, Math.min(buffer.length, numBytes))) != -1) {
            target.write(buffer, 0, bytesRead);
            numBytes -= bytesRead;
        }
    }

    private static void writeOffset(RandomAccessFile file, int value, int numBytes, int index)
            throws IOException {

        if (index == 13) {
            file.readUnsignedByte();
        }

        ArrayList<Integer> bytes = new ArrayList<>();


        // Generar los bytes en orden Little-Endian
        for (int i = 0; i < numBytes; i++) {
            bytes.add((value >> (i * 8)) & 0xFF);
        }

        // Eliminar ceros al final (no al principio)
        while (!bytes.isEmpty() && bytes.get(bytes.size() - 1) == 0) {
            bytes.remove(bytes.size() - 1);
        }

        // Si está vacío, añadir un 0¿?
        if (bytes.isEmpty()) {
            bytes.add(0);
        }

        // Rellenar con ceros al PRINCIPIO si la cantidad de bytes escritos es menor a numBytes
        while (bytes.size() < numBytes) {
            bytes.addFirst(0);
        }

        // Escribir los bytes en el archivo en orden Little-Endian
        for (int b : bytes) {
            file.write(b);
        }
    }

    private static void writeFinalOffset(RandomAccessFile file, int value, int numBytes, int index)
            throws IOException {
        file.seek(1066);

        ArrayList<Integer> bytes = new ArrayList<>();

        // Generar los bytes en orden Little-Endian
        for (int i = 0; i < numBytes; i++) {
            bytes.add((value >> (i * 8)) & 0xFF);
        }

        // Escribir los bytes en el archivo en orden Little-Endian
        for (int b : bytes) {
            file.write(b);
        }

    }
    // TODO BORRAR LOS PRIMEROS 64 BYTES (LAS PRIMERAS 4 LÍNEAS) ANTES DE METERLO EN EL JUEGO
    // PARA METERLO EN EL JUEGO, DESDE DOJAEMULATOR: TOOLS -> SCRATCHPAD -> REPLACE -> Seleccionar
    // el fichero -> APLLY -> SET
    // SI SSALE UN WARNING DE QUE NO S EHAN COPIDAODTODOS LOS DATOS, AMPLIAR EL TAMAÑO DEL SP EN
    // DOJAEMULATOR: ADF CONFIGURAION
}


