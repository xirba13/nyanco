/*
 * MyCanvas.java
 *
 * DATE : 2025/01/11 13:19
 */
import com.nttdocomo.ui.IApplication;
import com.nttdocomo.ui.Canvas;
import com.nttdocomo.ui.Graphics;
import com.nttdocomo.ui.Frame;
import com.nttdocomo.ui.Display;


/**
 * MyCanvas
 *
 * @author NAME
 */
import com.nttdocomo.ui.MediaPresenter;
import java.io.IOException;
import com.nttdocomo.io.ConnectionException;
import com.nttdocomo.opt.ui.j3d.Vector3D;
import com.nttdocomo.ui.MediaListener;
import com.nttdocomo.util.JarInflater;
import javax.microedition.io.Connector;
import com.nttdocomo.ui.MediaManager;
import com.nttdocomo.ui.PhoneSystem;
import com.nttdocomo.ui.MediaSound;
import com.nttdocomo.ui.AudioPresenter;
import com.nttdocomo.io.HttpConnection;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Calendar;
import com.nttdocomo.opt.ui.j3d.PrimitiveArray;
import com.nttdocomo.opt.ui.j3d.AffineTrans;
import java.util.Random;
import com.nttdocomo.opt.ui.j3d.Texture;
import com.nttdocomo.ui.Image;
import com.nttdocomo.opt.ui.j3d.Graphics3D;
import com.nttdocomo.ui.Graphics;
import com.nttdocomo.ui.MediaImage;
import com.nttdocomo.ui.Font;
import com.nttdocomo.ui.Canvas;

class MyCanvas extends Canvas implements Runnable
{
    static Font[] font;
    static String platform;
    static MediaImage media;
    static Graphics g;
    static Graphics3D g3d;
    static Image[] img;
    static MediaImage[] mimg;
    static Texture[] tex;
    static Texture[] etex;
    static Image load_img;
    static Image wakuimg;
    static int[] sivar;
    static long[] slvar;
    static int[] givar;
    static final int SAVE_VER = 1;
    static final int DATA_VER = 1;
    static final int DATA_OFFSET = 1000;
    static int[] data_offset;
    static final String[] url;
    static final String[] url2;
    static final int KEY_U = 131076;
    static final int KEY_D = 524544;
    static final int KEY_L = 65552;
    static final int KEY_R = 262208;
    static final int KEY_SEL = 1048608;
    static final int KEY_S1 = 2097152;
    static final int KEY_S2 = 4194304;
    static final int KEY_0 = 1;
    static final int KEY_1 = 2;
    static final int KEY_2 = 4;
    static final int KEY_3 = 8;
    static final int KEY_4 = 16;
    static final int KEY_5 = 32;
    static final int KEY_6 = 64;
    static final int KEY_7 = 128;
    static final int KEY_8 = 256;
    static final int KEY_9 = 512;
    static final int KEY_P = 2048;
    static final int KEY_A = 1024;
    static final int SCN_I_MAIN = 0;
    static final int SCN_I_DL = 1;
    static final int SCN_I_LOAD = 2;
    static final int SCN_I_NET = 10;
    static final int SCN_I_ERR = 11;
    static final int SCN_I_MYMENU = 12;
    static final int SCN_T_MAIN = 100;
    static final int SCN_T_MENU = 150;
    static final int SCN_T_CFG = 151;
    static final int SCN_T_SITE = 152;
    static final int SCN_T_CFG2 = 153;
    static final int SCN_T_SITE2 = 154;
    static final int SCN_T_MENU2 = 155;
    static final int SCN_T_CFG3 = 156;
    static final int SCN_T_MENU3 = 157;
    static final int SCN_T_MENU4 = 158;
    static final int SCN_T_MENU5 = 159;
    static final int SCN_T_SITE3 = 160;
    static final int SCN_T_SITE4 = 161;
    static final int SCN_R_CON = 250;
    static final int SCN_R_ERR = 251;
    static final int SCN_G_MAIN = 300;
    static final int SCN_G_MENU = 350;
    static final int SCN_G_CFG = 351;
    static final int SCN_G_MENU2 = 352;
    static final int SCN_K_1 = 400;
    static final int SCN_K_2 = 401;
    static final int SCN_K_3 = 402;
    static final int SCN_O_1 = 500;
    static final int SCN_O_2 = 501;
    static final int SCN_O_3 = 502;
    static final int SCN_TAIKEN1 = 20;
    static final String[] cfg_vol;
    static String[] soft_label;
    Random ran;
    static final int[] bunrui;
    int[] save0;
    int[] save1;
    int[] save2;
    int[] save5;
    int[] save3;
    int[] save4;
    int[] save6;
    int taikenban;
    static final int MAX = 51;
    static final int ZBUF = 200;
    static final int MST = 47;
    static final int LVM = 10;
    static AffineTrans trans;
    static PrimitiveArray[] pri;
    int[][] z_tbl;
    int syoki_iti;
    int taiken_flg;
    int[] p_flg;
    int[][] p_flg2;
    int t_flg;
    int[][] t_flg2;
    int[][][] uni;
    int[][][] ef1;
    int[][] ef2;
    int[] c_dai;
    int[] dat;
    int[][] dat2;
    int[][][] uni_dat1;
    int[][] uni_dat2;
    int[][] t_h1;
    int t_h2;
    int[] kiri;
    int[] p_flg3;
    Calendar cal;
    int nen;
    int[][] hosi;
    int[][] yuki;
    int[][] hinoko;
    int[] fe;
    int[] bak_tbl1;
    int[] bak_tbl2;
    int[][][] uni_pt1;
    int[][][] uni_pt2;
    int[][][] uni_pt3;
    int[] hati1;
    int[] kuma1;
    int[] kan1;
    int[] mos1;
    int[] mos2;
    int[] mos3;
    int[] mos4;
    int[] mos5;
    int[] blv1_1;
    int[] blv1_2;
    int[] blv1_3;
    int[] s_tbl1;
    int[] s_tbl2;
    int[] s_tbl3;
    String[] s_moji;
    String[] c_moji;
    int[] n_tbl1;
    int[] n_tbl2;
    int[] fusuma1;
    int[] fusuma2;
    int[] fusuma3;
    int[] men1;
    int[] men2;
    int[] men3;
    int[] tizu1;
    String[] tizu2;
    int[] tizu3;
    int[] tizu4;
    int[] tizu5;
    int[] kiri_tbl1;
    int[] kiri_tbl2;
    int[] kiri_tbl3;
    int[][] shop1;
    int[] shop2;
    String[] shop3;
    String[] shop4;
    String[] shop5;
    int[] nyan1;
    int[] nyan2;
    int nyan3;
    int[] nyan4;
    int[] nyan5;
    int[] nyan6;
    int[] nyan7;
    int[] nyan8;
    int[] nyan9;
    int[][] nyan10;
    int[] nyan11;
    int[] nyan12;
    int[] nyan13;
    int[] ta1;
    int[][] ta2;
    int[] ta3;
    String[] ta4;
    String[] ta5;
    String[] ta6;
    int[] ta7;
    String[] op_moji;
    String[] ed_moji;
    int[] t_ani1;
    int[] t_ani2;
    int[] t_ani3;
    int[] zukan1;
    int[] zukan2;
    String[][] zukan3;
    int[] zukan4;
    int[] cos_tbl;
    static InputStream is;
    static OutputStream os;
    static HttpConnection hc;
    static final int ALIGN_CENTER = 0;
    static final int ALIGN_LEFT = 1;
    static final int ALIGN_RIGHT = 2;
    static final int VALIGN_TOP = 4;
    static final int VALIGN_BOTTOM = 8;
    static final int OPT_SET = 16;
    static final int ADD_LABEL = 1;
    static final int ADD_MENU = 2;
    static final int ADD_LIST = 4;
    static int[][] wnd_param;
    static int[][][] item_param;
    static String[][] wnd_str;
    static String[][] item_str;
    static String wnd_default;
    static final int SE_CUR = 10;
    static final int SE_SEL = 11;
    static final int SE_CANCEL = 12;
    static final int IS_BGM = 1;
    static final int IS_SE = 2;
    static final int IS_INT = 4;
    static final int IS_LOOP = 8;
    static final int IS_PRI_MIN = 16;
    static final int IS_PRI_L = 32;
    static final int IS_PRI_H = 64;
    static final int IS_PRI_MAX = 128;
    static final int IS_ONLY = 256;
    static final int IS_REPLAY = 512;
    static final int[] snd_ele;
    static AudioPresenter[] audio;
    static MediaSound[] snd;
    static MyMediaListener[] mml;
    static int[] snd_val;
    static int[][] snd_data;
    static long[] snd_time;
    static int[] snd_opt;
    static final int SND_PAUSE = -1;
    static final int SND_STOP = -2;
    static final int SND_REPLAY = -3;
    static final int SND_SE = -4;
    static final int STOP_ALL = 0;
    static final int STOP_NUM = 1;
    static final int STOP_PORT = 2;
    
    public MyCanvas() {
        this.ran = new Random(System.currentTimeMillis());
        this.save0 = new int[34];
        this.save1 = new int[24];
        this.save2 = new int[49];
        this.save5 = new int[49];
        this.save3 = new int[24];
        this.save4 = new int[49];
        this.save6 = new int[49];
        this.z_tbl = new int[201][3];
        this.syoki_iti = -1;
        this.taiken_flg = 0;
        this.p_flg = new int[30];
        this.p_flg2 = new int[11][3];
        this.t_flg2 = new int[20][2];
        this.uni = new int[2][51][24];
        this.ef1 = new int[2][56][3];
        this.ef2 = new int[6][5];
        this.c_dai = new int[2];
        this.dat = new int[6];
        this.dat2 = new int[20][8];
        this.uni_dat1 = new int[11][10][14];
        this.uni_dat2 = new int[32][13];
        this.t_h1 = new int[52][2];
        this.kiri = new int[2];
        this.p_flg3 = new int[11];
        this.hosi = new int[20][4];
        this.yuki = new int[20][4];
        this.hinoko = new int[20][6];
        this.fe = new int[4];
        this.bak_tbl1 = new int[] { 0, -50, -30, -10, 0, 10, 30, 50, -20, -10, 10, 20 };
        this.bak_tbl2 = new int[] { 0, -40, -20, 0, 20, 40 };
        this.uni_pt1 = new int[][][] { { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, { 4 }, { 7, 7, 6, 6, 8, 9, 9, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 4 }, { 5, 5, 6, 7, 8 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 4, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, { 7 }, { 7, 7, 8, 9, 8, 10, 11, 11, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 4 }, { 4, 5, 6, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 }, { 6 }, { 7, 7, 8, 7, 8, 7, 8, 7, 8, 9, 10, 11, 12, 13, 13, 13 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } } };
        this.uni_pt2 = new int[][][] { { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, { 0 }, { 6, 6, 7, 8, 9, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 4 }, { 5, 5, 6, 7, 8 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 0, 1, 2, 3, 4, 4, 4, 3, 2, 1 }, { 0, 0, 0, 1, 2, 3, 4, 4, 4, 3, 2, 1 }, { 5, 5, 6, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, { 7 }, { 7, 7, 8, 9, 8, 10, 11, 11, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 4 }, { 4, 4, 5, 6, 7, 8, 9, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 }, { 6, 6 }, { 7, 7, 8, 7, 8, 7, 8, 7, 8, 9, 10, 11, 12, 13, 13, 13, 13 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 } } };
        this.uni_pt3 = new int[][][] { { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 3, 3, 2, 2, 1, 1, 0, 0, 2, 2 }, { 3 }, { 7, 7, 6, 7, 5, 4, 4, 4, 4 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 1, 2, 3, 4, 5 }, { 0 }, { 6, 6, 7, 8, 9, 10, 11, 10, 11, 10, 11, 12, 13, 14, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 5, 6, 6, 5, 7, 8, 9, 10, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10 }, { 0 }, { 11, 11, 12, 12, 13, 14, 15, 16, 17, 12, 11, 11, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 }, { 5 }, { 6, 6, 7, 6, 8, 9, 10, 11, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 5, 6, 5, 6, 7, 8, 9, 4, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0 }, { 4, 4, 5, 4, 6, 7, 8, 8, 8, 8 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 1, 1, 1, 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 1 }, { 3, 3, 4, 5, 6, 7, 7, 7, 7 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 4, 4 }, { 0 }, { 5, 5, 6, 7, 8, 9, 10, 10, 10, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7 }, { 8 }, { 9, 9, 10, 9, 11, 12 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 }, { 6 }, { 7, 7, 8, 7, 9, 10, 10, 10, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, { 0 }, { 6, 6, 7, 6, 8, 9, 10, 10, 10, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, { 0 }, { 1, 1, 6, 7, 8, 9, 10, 11 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 1, 1, 2, 2, 3, 3, 4, 4 }, { 0 }, { 5, 5, 6, 5, 7, 8 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 1, 2, 3, 4, 5 }, { 6 }, { 7, 7, 8, 9, 10 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8, 8, 8, 7, 7, 6, 6, 5, 4, 3, 2, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8, 8, 8, 7, 7, 6, 6, 5, 4, 3, 2, 1, 1 }, { 9, 9, 10, 11, 12, 13, 14, 15, 16, 15 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8, 8, 8, 7, 7, 6, 6, 5, 4, 3, 2, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8, 8, 8, 7, 7, 6, 6, 5, 4, 3, 2, 1, 1 }, { 9, 9, 10, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 14, 15, 16, 15 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 }, { 5 }, { 5, 5, 6, 5, 7, 8, 8, 8 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 }, { 5, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 30, 31, 35, 32, 32, 33, 33, 34, 34, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } }, { { 0, 0, 1, 1, 0, 0, 2, 2 }, { 0 }, { 3, 3, 4, 3, 5, 6, 6, 6, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0 } } };
        this.hati1 = new int[] { 3, 0, 3, 4, 1, 2 };
        this.kuma1 = new int[] { 0, 1, 2, 0, 1, 2, 1 };
        this.kan1 = new int[] { 98, 99, 100, 100, 99, 98 };
        this.mos1 = new int[] { 86, 0, 71, 89, 85, 89, 74, 88, 0, 0, 86, 60, 0, 60, 85, 57, 0, 117, 84, 64 };
        this.mos2 = new int[] { 61, 117, 64, 115, 75, 70, 75, 71, 74, 93 };
        this.mos3 = new int[] { 61, 117, 65, 117, 77, 72, 78, 73, 78, 96 };
        this.mos4 = new int[] { 0, -5, -10, 10, 5, -15 };
        this.mos5 = new int[] { 63, 58, 64, 59, 63, 81 };
        this.blv1_1 = new int[] { 0, 2, 1, 2, 3 };
        this.blv1_2 = new int[] { 5, 6, 7, 8, 9, 10, 11, 12 };
        this.blv1_3 = new int[] { 30, 26, 22, 18, 14, 10, 6, 1 };
        this.s_tbl1 = new int[] { 240, 240, 127, 63, 31, 15, 7, 3, 1, 0 };
        this.s_tbl2 = new int[] { -54, -54, -54, -54, -54, -54, -54, -54, -54, -24, 6, 36, 66, 96, 90, 87, 86, 85, 86, 87, 90, 96, 95, 94, 95, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96 };
        this.s_tbl3 = new int[] { -53, -23, 7, 37, 67, 97, 91, 88, 87, 86, 87, 88, 91, 97, 96, 95, 96, 97, 97, 97, 97, 97 };
        this.s_moji = new String[] { "\u3010\u306b\u3083\u3093\u3053\u7832\u3011\u5f37\u529b\u306a\u30d3\u30fc\u30e0\u7832\u3092\u767a\u5c04\u53ef\u80fd", "\u305f\u3060\u3057\u30c1\u30e3\u30fc\u30b8\u6642\u9593\u304c\u5fc5\u8981\u3067\u3059", "\u3010\u50cd\u304d\u30cd\u30b3\u3011[\u304a\u91d1\u306e\u751f\u7523\u30b9\u30d4\u30fc\u30c9]\u3068", "[\u304a\u91d1\u306e\u6700\u5927\u5024]\u304c\u30a2\u30c3\u30d7\u3067\u304d\u307e\u3059", "", "", "", "", "", "", "\u3053\u306e\u753b\u9762\u3092\u629c\u3051\u307e\u3059", "[\u4fbf\u5229\u6a5f\u80fd] \ue6eb\u30ad\u30fc\u3067\u753b\u9762\u304c\u6575\u3092\u81ea\u52d5\u8ffd\u5c3e", "\u3010\u30cd\u30b3\u3011\u5b89\u4fa1\u3067\u751f\u7523\u3067\u304d\u308b\u57fa\u672c\u30e6\u30cb\u30c3\u30c8", "", "\u3010\u30bf\u30f3\u30af\u30cd\u30b3\u3011\u653b\u6483\u529b\u306f\u5f31\u3044\u304c\u4f53\u529b\u3092", "\u591a\u304f\u5099\u3048\u305f\u76fe\u7528\u306e\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u3010\u30d0\u30c8\u30eb\u30cd\u30b3\u3011\u6226\u95d8\u5411\u304d\u306e\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u3081\u3063\u307d\u3046\u5f37\u3044", "\u3010\u30ad\u30e2\u30cd\u30b3\u3011\u9060\u8ddd\u96e2\u653b\u6483\u578b\u306e\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30cf\u30a4\u30af\u30e9\u30b9", "\u3010\u30a6\u30b7\u30cd\u30b3\u3011\u4fca\u654f\u306a\u52d5\u304d\uff65\u653b\u6483\u56de\u6570\u306b", "\u512a\u308c\u305f\u7dca\u6025\u652f\u63f4\u578b\u306e\u30e6\u30cb\u30c3\u30c8", "\u3010\u30cd\u30b3\u30ce\u30c8\u30ea\u3011\u5b88\u308a\u306f\u5f31\u3044\u304c\u6575\u3092\u307e\u3068\u3081\u3066", "\u4e00\u6383\u3059\u308b\u7834\u58ca\u529b\u3092\u6301\u3064\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u3010\u30cd\u30b3\u30d5\u30a3\u30c3\u30b7\u30e5\u3011\u6226\u95d8\u7528\u9ad8\u7d1a\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u306f\u3081\u3063\u307d\u3046\u5f37\u3044", "\u3010\u30cd\u30b3\u30c8\u30ab\u30b2\u3011\u9060\u8ddd\u96e2\u578b\u306e\u9ad8\u7d1a\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30d4\u30ab\u30a4\u30c1", "\u3010\u5de8\u795e\u30cd\u30b3\u3011\u8d85\u7d76\u7834\u58ca\u529b\uff06\u5f37\u976d\u306a\u4f53\u529b\u3092", "\u5099\u3048\u305f\u6700\u9ad8\u7d1a\u306e\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u3010\u30cd\u30b3\u30d3\u30eb\u30c0\u30fc\u3011", "\u5b89\u4fa1\u3067\u751f\u7523\u3067\u304d\u308b\u57fa\u672c\u30e6\u30cb\u30c3\u30c8", "\u3010\u30cd\u30b3\u30ab\u30d9\u3011\u653b\u6483\u529b\u306f\u5f31\u3044\u304c\u4f53\u529b\u3092", "\u591a\u304f\u5099\u3048\u305f\u76fe\u7528\u306e\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u3010\u52c7\u8005\u30cd\u30b3\u3011\u6226\u95d8\u5411\u304d\u306e\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u3081\u3063\u307d\u3046\u5f37\u3044", "\u3010\u7f8e\u811a\u30cd\u30b3\u3011\u9060\u8ddd\u96e2\u653b\u6483\u578b\u306e\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30cf\u30a4\u30af\u30e9\u30b9", "\u3010\u30cd\u30b3\u30ad\u30ea\u30f3\u3011\u4fca\u654f\u306a\u52d5\u304d\uff65\u653b\u6483\u56de\u6570\u306b", "\u512a\u308c\u305f\u7dca\u6025\u652f\u63f4\u578b\u306e\u30e6\u30cb\u30c3\u30c8", "\u3010\u30cd\u30b3\uff35\uff26\uff2f\u3011\u5b88\u308a\u306f\u5f31\u3044\u304c\u6575\u3092\u307e\u3068\u3081\u3066", "\u4e00\u6383\u3059\u308b\u7834\u58ca\u529b\u3092\u6301\u3064\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u3010\u30cd\u30b3\u30af\u30b8\u30e9\u3011\u6226\u95d8\u7528\u9ad8\u7d1a\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u306f\u3081\u3063\u307d\u3046\u5f37\u3044\u3044", "\u3010\u30cd\u30b3\u30c9\u30e9\u30b4\u30f3\u3011\u9060\u8ddd\u96e2\u578b\u306e\u9ad8\u7d1a\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30d4\u30ab\u30a4\u30c1", "\u3010\u30cd\u30b3\u30c0\u30e9\u30dc\u30c3\u30c1\u3011\u8d85\u7d76\u7834\u58ca\u529b\uff06\u5f37\u976d\u306a", "\u4f53\u529b\u3092\u6301\u3064\u6700\u9ad8\u7d1a\u306e\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\uff1f\uff1f\uff1f", "" };
        this.c_moji = new String[] { "", "\u304a\u91d1\u304c\u8db3\u308a\u307e\u305b\u3093\uff01", "\u30c1\u30e3\u30fc\u30b8\u304c\u7d42\u4e86\u3057\u3066\u3044\u307e\u305b\u3093\uff01", "\u3053\u308c\u4ee5\u4e0a\u5f37\u5316\u51fa\u6765\u307e\u305b\u3093\uff01", "\u307e\u3060\u53d6\u5f97\u3057\u3066\u3044\u307e\u305b\u3093\uff01", "\u307e\u3060\u751f\u7523\u3067\u304d\u307e\u305b\u3093\uff01", "\u3053\u308c\u4ee5\u4e0a\u51fa\u6483\u3067\u304d\u307e\u305b\u3093\uff01", "\u7d4c\u9a13\u5024\u304c\u8db3\u308a\u307e\u305b\u3093\uff01", "\u307e\u3060\u53d6\u5f97\u3067\u304d\u307e\u305b\u3093\uff01" };
        this.n_tbl1 = new int[] { 240, 231, 226, 206, 152, 151, 152, 163 };
        this.n_tbl2 = new int[] { 161, 160, 160, 159, 159, 159, 159, 161, 161, 161, 161, 161, 161, 161, 161, 161 };
        this.fusuma1 = new int[] { 1, 3, 13, 33, 63, 120 };
        this.fusuma2 = new int[] { 72, 40, 8, 4, 2, 1, 0 };
        this.fusuma3 = new int[] { 104, 40, 8, 4, 2, 1, 0 };
        this.men1 = new int[] { -10, -11, -10, 6, 42, 106, 170 };
        this.men2 = new int[] { 0, 16, 16, 8, 4, 2, 1, 1, 0, 0, 0, 0, 0, 0 };
        this.men3 = new int[] { 240, 191, 127, 63, 31, 15, 7, 3, 1, 0, 0, 0, 0, 0 };
        this.tizu1 = new int[] { 0, 0, 93, 88, 257, 0, 93, 0, 29, 28, 258, 84, 122, 0, 21, 32, 255, 107, 143, 0, 23, 34, 270, 107, 166, 0, 18, 29, 253, 132, 184, 0, 20, 24, 267, 136, 204, 0, 31, 23, 247, 156, 93, 34, 19, 23, 256, 177, 112, 34, 15, 19, 250, 172, 127, 34, 20, 21, 236, 174, 147, 34, 18, 10, 241, 189, 165, 34, 16, 7, 244, 196, 181, 34, 17, 22, 257, 193, 198, 34, 15, 11, 243, 200, 93, 57, 35, 35, 224, 145, 128, 57, 23, 35, 218, 175, 151, 57, 14, 15, 233, 195, 165, 57, 27, 20, 221, 201, 192, 57, 17, 14, 210, 175, 209, 57, 21, 26, 203, 185, 0, 92, 18, 15, 209, 206, 18, 92, 18, 29, 202, 164, 36, 92, 22, 19, 190, 188, 58, 92, 11, 17, 195, 200, 69, 92, 18, 29, 196, 209, 87, 92, 10, 17, 192, 217, 97, 92, 18, 20, 181, 198, 115, 92, 10, 15, 185, 212, 125, 92, 16, 18, 184, 225, 141, 92, 18, 28, 172, 200, 159, 92, 22, 11, 154, 201, 181, 92, 17, 17, 157, 207, 198, 92, 26, 26, 132, 201, 0, 121, 22, 17, 138, 211, 22, 121, 22, 15, 119, 219, 44, 121, 15, 8, 161, 224, 59, 121, 17, 13, 163, 227, 76, 121, 24, 23, 139, 229, 100, 121, 27, 21, 146, 234, 127, 121, 18, 19, 107, 232, 145, 121, 20, 18, 119, 237, 165, 121, 18, 27, 117, 253, 183, 121, 21, 21, 105, 246, 204, 121, 17, 23, 108, 264, 221, 121, 13, 12, 102, 239, 0, 148, 17, 15, 96, 243, 17, 148, 37, 42, 70, 331, 54, 148, 6, 5, 0, 408, 0, 0, 0, 0, 0, 0 };
        this.tizu2 = new String[] { "\u5317\u6d77\u9053", "\u9752\u68ee\u770c", "\u79cb\u7530\u770c", "\u5ca9\u624b\u770c", "\u5c71\u5f62\u770c", "\u5bae\u57ce\u770c", "\u798f\u5cf6\u770c", "\u8328\u57ce\u770c", "\u6803\u6728\u770c", "\u7fa4\u99ac\u770c", "\u57fc\u7389\u770c", "\u6771\u4eac\u90fd", "\u5343\u8449\u770c", "\u795e\u5948\u5ddd\u770c", "\u65b0\u6f5f\u770c", "\u9577\u91ce\u770c", "\u5c71\u68a8\u770c", "\u9759\u5ca1\u770c", "\u5bcc\u5c71\u770c", "\u5c90\u961c\u770c", "\u611b\u77e5\u770c", "\u77f3\u5ddd\u770c", "\u798f\u4e95\u770c", "\u6ecb\u8cc0\u770c", "\u4e09\u91cd\u770c", "\u5948\u826f\u770c", "\u4eac\u90fd\u5e9c", "\u5927\u962a\u5e9c", "\u548c\u6b4c\u5c71\u770c", "\u5175\u5eab\u770c", "\u9ce5\u53d6\u770c", "\u5ca1\u5c71\u770c", "\u5cf6\u6839\u770c", "\u5e83\u5cf6\u770c", "\u5c71\u53e3\u770c", "\u9999\u5ddd\u770c", "\u5fb3\u5cf6\u770c", "\u611b\u5a9b\u770c", "\u9ad8\u77e5\u770c", "\u798f\u5ca1\u770c", "\u5927\u5206\u770c", "\u5bae\u5d0e\u770c", "\u718a\u672c\u770c", "\u9e7f\u5150\u5cf6\u770c", "\u4f50\u8cc0\u770c", "\u9577\u5d0e\u770c", "\u6c96\u7e04\u770c", "\u897f\u8868\u5cf6", "\u4e88\u5099" };
        this.tizu3 = new int[] { 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 46, 47, 48 };
        this.tizu4 = new int[] { 0, 45, 75, 90, 95, 98, 100 };
        this.tizu5 = new int[] { 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 3, 90, 30, 3, 0, 4, 3, 0, 4, 3, 90, 31, 3, 0, 4, 3, 0, 4, 3, 85, 32, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 93, 31, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 3, 0, 4, 3, 99, 31, 3, 0, 4, 3, 0, 4, 3, 92, 31, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 30, 0, 4, 3, 99, 32, 31, 0, 4, 33, 0, 4, 3, 0, 4, 4, 0, 4, 6, 60, 4 };
        this.kiri_tbl1 = new int[] { 240, 240, 240, 240, 240, 219, 199, 159, 79, -1, -41, -41 };
        this.kiri_tbl2 = new int[] { 160, 80, 0, -41 };
        this.kiri_tbl3 = new int[] { 1, 2, 4, 8, 16, 32, 64, 120, 120, 120 };
        this.shop1 = new int[][] { { 1000, 2000, 4000, 8000, 12000, 16000, 20000, 24000, 28000 }, { 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500 }, { 500, 1000, 2000, 4000, 6000, 8000, 10000, 12000, 15000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 }, { 0 }, { 0 }, { 0, 400, 700, 1100, 1600, 2200, 2900, 3700, 4600, 5600 }, { 500, 700, 1600, 2800, 4300, 6100, 8200, 10600, 13300, 16300 }, { 2000, 900, 1800, 3000, 4500, 6300, 8400, 10800, 13500, 16500 }, { 3000, 1300, 2200, 3400, 4900, 6700, 8800, 11200, 13900, 16900 }, { 4000, 1500, 2400, 3600, 5100, 6900, 9000, 11400, 14100, 17100 }, { 5000, 2000, 3200, 4800, 6800, 9200, 12000, 15200, 18800, 22800 }, { 6000, 2500, 4000, 6000, 8500, 11500, 15000, 19000, 23500, 28500 }, { 7000, 3000, 4800, 7200, 10200, 13800, 18000, 22800, 28200, 34200 }, { 8000, 3500, 6200, 9800, 14300, 19700, 26000, 33200, 41300, 50300 } };
        this.shop2 = new int[] { 0, 1, 3, 6, 9, 12, 16, 20, 24 };
        this.shop3 = new String[] { "\u306b\u3083\u3093\u3053\u7832\u653b\u6483\u529b", "\u7834\u58ca\u529b\u304c\u30a2\u30c3\u30d7\u3057\u307e\u3059", "\u305f\u3060\u3057\u30c1\u30e3\u30fc\u30b8\u6642\u9593\u304c\u5c11\u3057\u4f38\u3073\u307e\u3059", "\u306b\u3083\u3093\u3053\u7832\u5c04\u7a0b", "\u5c04\u7a0b\u8ddd\u96e2\u304c\u30a2\u30c3\u30d7\u3057\u307e\u3059", "", "\u306b\u3083\u3093\u3053\u7832\u30c1\u30e3\u30fc\u30b8", "\u767a\u5c04\u53ef\u80fd\u306b\u306a\u308b\u307e\u3067\u306e", "\u30c1\u30e3\u30fc\u30b8\u6642\u9593\u304c\u65e9\u304f\u306a\u308a\u307e\u3059", "\u50cd\u304d\u30cd\u30b3\u4ed5\u4e8b\u52b9\u7387", "\u50cd\u304d\u30cd\u30b3\u306e\u4ed5\u4e8b\u52b9\u7387\u3092\u4e0a\u3052", "\u304a\u91d1\u306e\u5897\u52a0\u30b9\u30d4\u30fc\u30c9\u304c\u30a2\u30c3\u30d7\u3057\u307e\u3059", "\u50cd\u304d\u30cd\u30b3\u304a\u8ca1\u5e03", "\u50cd\u304d\u30cd\u30b3\u306e\u304a\u8ca1\u5e03\u30b5\u30a4\u30ba\u3092\u30a2\u30c3\u30d7\u3055\u305b", "\u6226\u95d8\u4e2d\u306b\u6240\u6301\u3067\u304d\u308b\u304a\u91d1\u304c\u5897\u52a0\u3057\u307e\u3059", "\u304a\u57ce\u4f53\u529b", "\u81ea\u5206\u306e\u57ce\u306e\u4f53\u529b\u304c\u30a2\u30c3\u30d7\u3057\u307e\u3059", "", "\u7814\u7a76\u529b", "\u30e6\u30cb\u30c3\u30c8\u306e\u751f\u7523\u30b9\u30d4\u30fc\u30c9\u3092", "\u30a2\u30c3\u30d7\u3055\u305b\u308b\u3053\u3068\u304c\u3067\u304d\u307e\u3059", "\u4f1a\u8a08\u529b", "\u6575\u3092\u5012\u3059\u305f\u3073\u306b\u5f97\u308c\u308b", "\u304a\u91d1\u3092\u30a2\u30c3\u30d7\u3055\u305b\u308b\u3053\u3068\u304c\u3067\u304d\u307e\u3059", "\u52c9\u5f37\u529b", "\u30b9\u30c6\u30fc\u30b8\u30af\u30ea\u30a2\u6642\u306b\u53d6\u5f97\u3067\u304d\u308b", "\u7d4c\u9a13\u5024\u3092\u5897\u52a0\u3055\u305b\u308b\u3053\u3068\u304c\u3067\u304d\u307e\u3059" };
        this.shop4 = new String[] { "\u30cd\u30b3", "\u30bf\u30f3\u30af\u30cd\u30b3", "\u30d0\u30c8\u30eb\u30cd\u30b3", "\u30ad\u30e2\u30cd\u30b3", "\u30a6\u30b7\u30cd\u30b3", "\u30cd\u30b3\u30ce\u30c8\u30ea", "\u30cd\u30b3\u30d5\u30a3\u30c3\u30b7\u30e5", "\u30cd\u30b3\u30c8\u30ab\u30b2", "\u5de8\u795e\u30cd\u30b3", "\u30cd\u30b3\u30d3\u30eb\u30c0\u30fc", "\u30cd\u30b3\u30ab\u30d9", "\u52c7\u8005\u30cd\u30b3", "\u7f8e\u811a\u30cd\u30b3", "\u30cd\u30b3\u30ad\u30ea\u30f3", "\u30cd\u30b3\uff35\uff26\uff2f", "\u30cd\u30b3\u30af\u30b8\u30e9", "\u30cd\u30b3\u30c9\u30e9\u30b4\u30f3", "\u30cd\u30b3\u30c0\u30e9\u30dc\u30c3\u30c1" };
        this.shop5 = new String[] { "0", "", "\uff11\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff13\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff16\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff19\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff11\uff12\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff11\uff16\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff12\uff10\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "\uff12\uff14\u30b9\u30c6\u30fc\u30b8\u3092\u5236\u8987\u3059\u308c\u3070", "\u53d6\u5f97\u53ef\u80fd\u306b\u306a\u308a\u307e\u3059", "2", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u53d6\u5f97\u53ef\u80fd\uff01\uff01", "", "\u5b89\u4fa1\u3067\u751f\u7523\u3067\u304d\u308b\u57fa\u672c\u30e6\u30cb\u30c3\u30c8", "", "\u4f53\u529b\u3092\u591a\u304f\u5099\u3048\u305f\u76fe\u7528\u306e\u30e6\u30cb\u30c3\u30c8", "\u653b\u6483\u529b\u306f\u30b9\u30ba\u30e1\u306e\u6d99\u307b\u3069(\u7bc4\u56f2\u653b\u6483)", "\u6226\u95d8\u5411\u304d\u306e\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u3081\u3063\u307d\u3046\u5f37\u3044", "\u9060\u304f\u306e\u6575\u3092\u653b\u6483\u3067\u304d\u308b\u9060\u8ddd\u96e2\u578b\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30cf\u30a4\u30af\u30e9\u30b9", "\u4fca\u654f\u306a\u52d5\u304d\u3067\u79fb\u52d5\u529b\u306b\u512a\u308c\u305f\u30e6\u30cb\u30c3\u30c8", "\u653b\u6483\u56de\u6570\u3082\u30cf\u30f3\u30d1\u306a\u3044", "\u4f53\u529b\u306f\u5c11\u306a\u3044\u304c\u6575\u3092\u307e\u3068\u3081\u3066\u4e00\u6383\u3059\u308b", "\u8d85\u7834\u58ca\u529b\u3092\u6301\u3063\u305f\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u6226\u95d8\u5411\u304d\u306e\u9ad8\u7d1a\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u306f\u3081\u3063\u307d\u3046\u5f37\u3044", "\u9060\u304f\u306e\u6575\u3092\u653b\u6483\u3067\u304d\u308b\u9060\u8ddd\u96e2\u578b\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30d4\u30ab\u30a4\u30c1", "\u8d85\u7d76\u7834\u58ca\u529b\uff06\u5f37\u976d\u306a\u4f53\u529b\u3092\u5099\u3048\u305f", "\u6700\u9ad8\u7d1a\u306e\u30e6\u30cb\u30c3\u30c8(\u7bc4\u56f2\u653b\u6483)", "\u935b\u3048\u306c\u3044\u305f\u7b4b\u8089\u304c\u30c1\u30e3\u30fc\u30e0\u30dd\u30a4\u30f3\u30c8\u306e", "\u57fa\u672c\u30e6\u30cb\u30c3\u30c8", "\u307e\u3055\u306b\u30ab\u30d9\u306b\u5fb9\u3059\u308b\u70ba\u306e\u76fe\u5c02\u7528\u30e6\u30cb\u30c3\u30c8", "\u653b\u6483\u529b\u306f\u3042\u3044\u304b\u308f\u3089\u305a(\u7bc4\u56f2\u653b\u6483)", "\u52c7\u8005\u306b\u3042\u3053\u304c\u308c\u308b\u6226\u95d8\u5411\u304d\u306e\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u3081\u3063\u307d\u3046\u5f37\u3044", "\u7f8e\u3057\u3059\u304e\u308b\u8db3\u304c\u81ea\u6162\u306e\u9060\u8ddd\u96e2\u578b\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30cf\u30a4\u30af\u30e9\u30b9", "\u4fca\u654f\u306a\u52d5\u304d\u3067\u79fb\u52d5\u529b\u306b\u512a\u308c\u305f\u30e6\u30cb\u30c3\u30c8", "\u9577\u3044\u9996\u3067\u306e\u30d8\u30c3\u30c9\u30d0\u30c3\u30ad\u30f3\u30b0\u304c\u7b11\u3048\u308b", "\u91cd\u529b\u3092\u8d85\u8d8a\u3057\u305f\u6539\u9020\u306b\u3083\u3093\u3053", "\u6575\u3092\u307e\u3068\u3081\u3066\u304a\u4ed5\u7f6e\u304d\u53ef\u80fd(\u7bc4\u56f2\u653b\u6483)", "\u8089\u98df\u30af\u30b8\u30e9\u306b\u9032\u5316\u3057\u305f\u9ad8\u7d1a\u6226\u95d8\u30e6\u30cb\u30c3\u30c8", "\uff62\u8d64\u3044\u6575\uff63\u306b\u306f\u3081\u3063\u307d\u3046\u5f37\u3044", "\u5e7b\u60f3\u4e16\u754c\u304b\u3089\u964d\u81e8\u3057\u305f\u9060\u8ddd\u96e2\u578b\u30e6\u30cb\u30c3\u30c8", "\u5358\u767a\u3060\u3051\u306a\u3089\u653b\u6483\u529b\u306f\u30d4\u30ab\u30a4\u30c1", "\u8d85\u7d76\u7834\u58ca\u529b\uff06\u5f37\u976d\u306a\u4f53\u529b\u3092\u5099\u3048\u305f", "\u7834\u58ca\u3092\u3064\u304b\u3055\u3069\u308b\u30cd\u30b3\u795e\u69d8(\u7bc4\u56f2\u653b\u6483)" };
        this.nyan1 = new int[] { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        this.nyan2 = new int[] { 750, 725, 700, 675, 650, 625, 600, 575, 550, 525 };
        this.nyan3 = 40;
        this.nyan4 = new int[] { 100, 150, 200, 250, 300, 350, 400, 450, 500, 550 };
        this.nyan5 = new int[] { 4, 4, 3, 2, 1, 0 };
        this.nyan6 = new int[] { 0, 25, 50, 75, 100, 125, 150, 175, 200, 225 };
        this.nyan7 = new int[] { 1000, 2000, 3000, 4000, 6000, 8000, 10000, 12000, 15000, 18000 };
        this.nyan8 = new int[] { 50, 70, 90, 110, 130, 150, 170, 190, 210, 230 };
        this.nyan9 = new int[] { 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };
        this.nyan10 = new int[][] { { 4000, 8000, 12000, 16000, 20000, 24000, 28000 }, { 5000, 10000, 15000, 20000, 25000, 30000, 35000 }, { 6000, 12000, 18000, 24000, 30000, 36000, 42000 }, { 7000, 14000, 21000, 28000, 35000, 42000, 49000 }, { 8000, 16000, 24000, 32000, 40000, 48000, 56000 }, { 9000, 18000, 27000, 36000, 45000, 54000, 63000 }, { 10000, 20000, 30000, 40000, 50000, 60000, 70000 }, { 12000, 24000, 36000, 48000, 60000, 72000, 84000 }, { 14000, 28000, 42000, 56000, 70000, 84000, 98000 }, { 16000, 32000, 48000, 64000, 80000, 96000, 112000 } };
        this.nyan11 = new int[] { 100, 105, 110, 115, 120, 125, 130, 135, 140, 150 };
        this.nyan12 = new int[] { 0, 3, 6, 9, 12, 15, 18, 22, 26, 30 };
        this.nyan13 = new int[] { 100, 105, 110, 115, 120, 125, 130, 135, 140, 150 };
        this.ta1 = new int[] { 7, 4, 5, 7, 3, 3, 3, 7, 6, 1, 2 };
        this.ta2 = new int[][] { { 45, 44, 43, 42, 41, 40, 39 }, { 38, 37, 36, 35 }, { 34, 33, 32, 31, 30 }, { 29, 28, 27, 26, 25, 24, 23 }, { 22, 21, 18 }, { 19, 20, 17 }, { 16, 15, 14 }, { 13, 12, 11, 10, 9, 8, 7 }, { 6, 5, 4, 3, 2, 1 }, { 0 }, { 46, 47 } };
        this.ta3 = new int[] { 0, 0, 0, 1, 2, 4, 1 };
        this.ta4 = new String[] { "\u725b\u4e73", "\u308a\u3093\u3054", "\u304d\u308a\u305f\u3093\u307d", "\u308f\u3093\u3053\u305d\u3070", "\u3055\u304f\u3089\u3093\u307c", "\u30bf\u30f3", "\u559c\u591a\u65b9\u30e9\u30fc\u30e1\u30f3", "\u7d0d\u8c46", "\u9903\u5b50", "\u3053\u3093\u306b\u3083\u304f", "\u305b\u3093\u3079\u3044", "\u3082\u3093\u3058\u3083", "\u843d\u82b1\u751f", "\u5e72\u7269", "\u304a\u7c73", "\u4fe1\u5dde\u305d\u3070", "\u307b\u3046\u3068\u3046", "\u304a\u8336", "\u30db\u30bf\u30eb\u30a4\u30ab", "\u5de5\u82b8\u54c1", "\u307f\u305d", "\u5bff\u53f8", "\u30e1\u30ac\u30cd", "\u30d5\u30ca", "\u725b", "\u9e7f", "\u6f2c\u7269", "\u305f\u3053\u3084\u304d", "\u6885\u5e72\u3057", "\u660e\u77f3\u713c\u304d", "\u68a8", "\u6843", "\u51fa\u96f2\u305d\u3070", "\u304a\u597d\u307f\u713c\u304d", "\u30d5\u30b0", "\u3046\u3069\u3093", "\u3059\u3060\u3061", "\u307f\u304b\u3093", "\u30ab\u30c4\u30aa", "\u660e\u592a\u5b50", "\u713c\u914e", "\u30de\u30f3\u30b4\u30fc", "\u99ac\u523a\u3057", "\u3055\u3064\u307e\u3044\u3082", "\u30e0\u30c4\u30b4\u30ed\u30a6", "\u30ab\u30b9\u30c6\u30e9", "\u6ce1\u76db", "\u732b\u306e\u5fc3", "" };
        this.ta5 = new String[] { "\u7c97\u60aa\u306a", "\u666e\u901a\u306e", "\u6700\u9ad8\u306e" };
        this.ta6 = new String[] { "\u4e5d\u5dde\u306e\u7537\u3089\u3057\u3055 ", "\u50cd\u304d\u30cd\u30b3\u306e", "\u304a\u91d1\u751f\u7523\u91cf\u304c\u5897\u52a0\uff01", "\u56db\u56fd\u306e\u3046\u307e\u3044\u3082\u3093 ", "\u50cd\u304d\u30cd\u30b3\u306e", "\u8ca1\u5e03\u5bb9\u91cf\u304c\u5897\u52a0\uff01", "\u4e2d\u56fd\u306e\u4f1d\u7d71 ", "\u5473\u65b9\u30e6\u30cb\u30c3\u30c8\u306e", "\u751f\u7523\u30b9\u30d4\u30fc\u30c9\u304c\u30a2\u30c3\u30d7\uff01", "\u95a2\u897f\u306e\u30ce\u30ea ", "\u30b9\u30c6\u30fc\u30b8\u30af\u30ea\u30a2\u6642\u306e", "\u7d4c\u9a13\u5024\u304c\u5897\u52a0\uff01", "\u5317\u9678\u306e\u8c6a\u90b8 ", "\u5473\u65b9\u306e\u57ce\u306e", "\u4f53\u529b\u304c\u30a2\u30c3\u30d7\uff01", "\u6771\u6d77\u306e\u304c\u3081\u3064\u3055 ", "\u6575\u3092\u5012\u3059\u305f\u3073\u306b\u5f97\u308c\u308b", "\u304a\u91d1\u304c\u5897\u52a0\uff01", "\u7532\u4fe1\u8d8a\u306e\u96ea\u666f\u8272 ", "\u5473\u65b9\u30e6\u30cb\u30c3\u30c8\u306e", "\u4f53\u529b\u304c\u30a2\u30c3\u30d7\uff01", "\u95a2\u6771\u306e\u30ab\u30ea\u30b9\u30de ", "\u5473\u65b9\u30e6\u30cb\u30c3\u30c8\u306e", "\u653b\u6483\u529b\u304c\u30a2\u30c3\u30d7\uff01", "\u6771\u5317\u306e\u9b42 ", "\u306b\u3083\u3093\u3053\u7832\u306e", "\u653b\u6483\u529b\u304c\u30a2\u30c3\u30d7\uff01", "\u5317\u6d77\u9053\u306e\u30c7\u30ab\u3055 ", "\u306b\u3083\u3093\u3053\u7832\u306e", "\u30c1\u30e3\u30fc\u30b8\u30b9\u30d4\u30fc\u30c9\u30a2\u30c3\u30d7\uff01", "\u5357\u56fd\u306e\u98a8 ", "\u304a\u5b9d\u30b2\u30c3\u30c8\u306e", "\u78ba\u7387\u304c\u30a2\u30c3\u30d7\uff01" };
        this.ta7 = new int[] { 100, 100000, 30, 50, 7000, 50, 50, 50, 500, 150, 65 };
        this.op_moji = new String[] { "\u5e74\u3001\u5927\u6666\u65e5\u3002", "\u65e5\u672c\u5217\u5cf6\u304c\u8840\u306b\u67d3\u307e\u308b\u2026", "", "\u7d4c\u6e08\u4f4e\u8ff7\u3001\u653f\u6cbb\u4e0d\u4fe1", "\u5f31\u4f53\u5316\u3057\u7d9a\u3051\u308b\u65e5\u672c\u306b", "\u3068\u3064\u3058\u3087\u3068\u3057\u3066", "\u73fe\u308c\u305f\u300c\u306b\u3083\u3093\u3053\u8ecd\u56e3\u300d", "", "\u72c2\u703e\u6012\u6fe4\u2026\u51b7\u9177\u7121\u6b8b\u2026", "\u2026\u652f\u96e2\u6ec5\u88c2\u2026\u548c\u6c17\u85f9\u85f9", "\u713c\u8089\u5b9a\u98df\u2026\u611b\u7f85\u6b66\u52c7\u2026", "", "\u56db\u5b57\u719f\u8a9e\u3063\u307d\u3044\u306e\u3092\u4e26\u3079\u3066\u307f\u305f\u304c", "\u5974\u3089\u306e\u9032\u8ecd\u3092\u6b62\u3081\u308b\u3053\u3068\u306f\u3067\u304d\u306a\u3044", "", "\u305d\u3046\u3044\u3048\u3070\u3001", "\u300c\u306b\u3083\u3093\u3053\u300d\u3068\u300c\u3061\u3083\u3093\u3053\u300d\u306f", "\u97ff\u304d\u304c\u4f3c\u3066\u3044\u308b", "\u3057\u304b\u3057\u300c\u306b\u3083\u3093\u3053\u934b\u300d\u306f", "\u3042\u307e\u308a\u898b\u305f\u304f\u306a\u3044\u3082\u306e\u3060", "", "\u306b\u3083\u3093\u3053\u3092\u4e01\u5be7\u306b\u8a00\u3046\u3068", "\u300c\u304a\u306b\u3083\u3093\u3053\u300d\u3068\u306a\u308b", "\u3061\u3087\u3063\u3068\u61d0\u304b\u3057\u3044\u3068\u611f\u3058\u305f\u4eba\u306f", "\u3044\u3044\u5e74\u9803\u306e\u4eba\u3060\u308d\u3046", "", "\u3053\u306e\u524d\u3001\u624b\u7d19\u3092\u66f8\u3053\u3046\u3068\u3057\u3066", "\u66f8\u304d\u59cb\u3081\u305f\u306e\u306f\u3044\u3044\u304c", "\u4e45\u3005\u306b\u66f8\u3044\u305f\u81ea\u5206\u306e\u5b57\u304c", "\u4f59\u308a\u306b\u3082\u6c5a\u304f\u3066", "\u9014\u4e2d\u3067\u3084\u3081\u3066\u3057\u307e\u3063\u305f\u306e\u3092", "\u601d\u3044\u51fa\u3057\u305f", "", "\u305d\u3082\u305d\u3082\u8ab0\u306b\u51fa\u3059\u304b\u3082", "\u6c7a\u3081\u305a\u306b\u66f8\u304d\u59cb\u3081\u305f\u306e\u304c", "\u4e00\u756a\u306e\u5931\u6557\u3060", "", "", "\u5b50\u4f9b\u306e\u9803\u3001\u5927\u304d\u304f\u306a\u3063\u305f\u3089", "\u91ce\u7403\u9078\u624b\u306b\u306a\u308a\u305f\u3044\u3068\u304b", "\u5e73\u6c17\u306a\u9854\u3057\u3066\u8a00\u3063\u3066\u3044\u305f\u3051\u3069", "\u4eca\u601d\u3046\u3068\u6065\u305a\u304b\u3057\u3044", "", "\u307e\u3041\u3001", "\u6f2b\u753b\u5bb6\u3067\u5927\u91d1\u6301\u3061\u3002", "\u305d\u308c\u306f\u6210\u308c\u308b\u3082\u306e\u306a\u3089", "\u4eca\u3067\u3082\u6210\u308a\u305f\u3044\u3068\u601d\u3063\u3066\u308b", "", "", "", "", "\u304a\u91d1\u304c\u3042\u308c\u3070", "\u611b\u306a\u3093\u3066\u3044\u3089\u306a\u3044\uff1f", "", "\u306f\u3044     \u3044\u3044\u3048", "", "", "", "", "", "", "\u3069\u3063\u3061\u304c\u6b63\u3057\u3044\u304b\u306a\u3093\u3066", "\u6b63\u76f4\u3069\u3046\u3067\u3082\u3044\u3044\u3093\u3060\u3051\u3069", "", "\u305f\u3060\u4e00\u3064\u3060\u3051", "\u8a00\u3044\u305f\u3044\u3053\u3068\u306f", "", "", "\u300c\u306b\u3083\u3093\u3053\u8ecd\u56e3\u300d\u306f", "\u305d\u3093\u306a\u306b\u60aa\u3044\u5974\u3089\u3058\u3083\u306a\u3044\u3088\u266a", "", "", "\u2026\u3063\u3066\u3053\u3068\u3050\u3089\u3044\u3060" };
        this.ed_moji = new String[] { "\u3053\u3046\u3057\u3066", "\u65e5\u672c\u306f\u306b\u3083\u3093\u3053\u8ecd\u56e3\u306b\u3088\u3063\u3066", "\u5b8c\u5168\u306b\u5236\u5727\u3055\u308c\u305f\u2026", "", "", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\u306e", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\u306b\u3088\u308b", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\u306e\u70ba\u306e\u653f\u6cbb\u304c", "\u4eca\u3001\u306f\u3058\u307e\u308b\u306e\u3060\uff01", "", "", "", "", "\u2026\u3068\u601d\u3063\u3066\u3044\u305f\u3051\u3069", "\u3051\u3063\u304d\u3087\u304f", "\u30dc\u30af\u9054\u306e\u751f\u6d3b\u304c\u5909\u308f\u308b\u3053\u3068\u306f", "\u307e\u3063\u305f\u304f\u7121\u304b\u3063\u305f", "", "", "\u5909\u308f\u3063\u305f\u3053\u3068\u3068\u8a00\u3048\u3070", "\u3061\u3087\u3063\u3068\u3060\u3051", "\u300c\u30cd\u30b3\u300d\u304c\u5897\u3048\u305f", "", "", "\u305d\u308c\u3050\u3089\u3044\u3060", "", "", "", "", "\u3042\u3001\u305d\u3046\u305d\u3046", "", "\u3053\u306e\u307e\u3048\u30dc\u30af\u304c\u50cd\u3044\u3066\u3044\u308b", "\u4f1a\u793e\u306e\u9762\u63a5\u306b", "\u306b\u3083\u3093\u3053\u304c\u6765\u3066\u3044\u305f", "", "", "", "\u307e\u3041\u3001\u3044\u304f\u3089\u5fd9\u3057\u3044\u3068\u306f\u3044\u3048", "\u3084\u3063\u3071\u308a\u300c\u30cd\u30b3\u300d\u306a\u306e\u3067", "\u7d50\u679c\u306f\u4e0d\u63a1\u7528\u3060\u3063\u305f\u3093\u3060\u3051\u3069\u2026", "", "", "", "\u3067\u3082\u3001", "", "", "", "\u3082\u3057\u4f1a\u793e\u3084\u5b66\u6821\u306b", "\u306b\u3083\u3093\u3053\u304c\u3044\u305f\u3089\u2026", "", "", "", "\u306a\u3093\u3060\u304b\u3061\u3087\u3063\u3068\u3060\u3051", "\u3046\u308c\u3057\u3044\u3068\u601d\u3046\u306e\u306f", "\u30dc\u30af\u3060\u3051\u304b\u306a\uff1f (\u7b11)", "", "", "", "", "", "\u3069\u3061\u3089\u306b\u305b\u3088", "", "\u304a\u3081\u3067\u3068\u3046", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\uff01", "\u3042\u308a\u304c\u3068\u3046", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\uff01", "", "", "", "\u306b\u3083\u3093\u3053\u8ecd\u56e3\u3088", "\u6c38\u9060\u306b\uff01\uff01", "", "", "", "", "", "", "" };
        this.t_ani1 = new int[] { -240, -103, -87, -55, -23, 9, 5, 4, 5, 9, 8, 9 };
        this.t_ani2 = new int[] { 240, 171, 107, 43, 11, 5, 3, 1, 0 };
        this.t_ani3 = new int[] { 10, 11, 10, -6, -38, -102, -166, -240 };
        this.zukan1 = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 11, 16, 12, 17, 24, 13, 14, 20, 18, 19, 23 };
        this.zukan2 = new int[] { 138, 141, 139, 155, 154, 144, 147, 146, 158, 148, 152, 154, 150, 143, 141, 140, 150, 149, 149, 138, 138, 143, 150, 138, 138, 138, 138, 138, 138, 138 };
        this.zukan3 = new String[][] { { "\u3010\u308f\u3093\u3053\u3011", "\u306b\u3083\u3093\u3053\u3092\u52dd\u624b\u306b\u30e9\u30a4\u30d0\u30eb\u8996\u3059\u308b\u30b7\u30d0\u72ac\u3002", "\u306b\u3083\u3093\u3053\u306e\u8a95\u751f\u65e5\u306b\u306f\u5fd8\u308c\u305a\u30d7\u30ec\u30bc\u30f3\u30c8", "\u3092\u7528\u610f\u3059\u308b\u30de\u30e1\u306a\u4e00\u9762\u3082\u3042\u308b\u3002\u5b9f\u306f", "\u53d7\u9a13\u751f\u3067\u6bce\u5e74\u5927\u5b66\u53d7\u9a13\u306b\u6311\u6226\u3057\u3066\u3044\u308b\u3002" }, { "\u3010\u306b\u3087\u308d\u3011", "\u30d8\u30d3\u306e\u3088\u3046\u306a\u5f62\u3092\u3057\u305f\u30d8\u30d3\u3002\u4f53\u306e\u6a21\u69d8\u306f", "\u6c34\u5f69\u7d75\u306e\u5177\u3067\u30da\u30a4\u30f3\u30c8\u3057\u3066\u3044\u308b\u3002\u3064\u307e\u308a", "\u6c34\u306b\u306f\u5f31\u3044\u3002\u3060\u304c\u3001\u3053\u306e\u60c5\u5831\u306f\u30b2\u30fc\u30e0\u306b", "\u95a2\u4fc2\u7121\u3044\u306e\u3067\u6ce8\u610f\u304c\u5fc5\u8981\u3067\u3042\u308b\u3002" }, { "\u3010\u4f8b\u306e\u30e4\u30c4\u3011", "\u4e00\u4eba\u3060\u3068\u5fc3\u7d30\u3044\u306e\u3067\u3001\u30c8\u30ea\u30aa\u3067\u53c2\u6226\u3002", "\u4e00\u4eba\u76ee\u304c\u300c\u306b\u3083\u3093\u3053\u5927\u6226\u4e89\u300d\u3078\u306e\u53c2\u52a0\u3092", "\u30a4\u30f3\u30bf\u30fc\u30cd\u30c3\u30c8\u3067\u52df\u96c6\u3057\u3066\u96c6\u307e\u3063\u305f\u3002", "\u4e09\u4eba\u3068\u3082\u3051\u3063\u3053\u3046\u304a\u91d1\u6301\u3061\u3002" }, { "\u3010\u30ab\u30d0\u3061\u3083\u3093\u3011", "\u529b\u6301\u3061\u3067\u4f53\u529b\u306b\u3082\u81ea\u4fe1\u304c\u3042\u308b\u30ab\u30d0\u3002", "\u4e00\u5ea6\u306b\u8907\u6570\u4f53\u3092\u307e\u3068\u3081\u3066\u653b\u6483\u3057\u3066\u304f\u308b", "\u5371\u967a\u306a\u3084\u3064\u3002", "\u3061\u306a\u307f\u306b\u3001\u304a\u59c9\u30ad\u30e3\u30e9\u304b\u3069\u3046\u304b\u306f\u4e0d\u660e\u3002" }, { "\u3010\u30d6\u30bf\u30e4\u30ed\u30a6\u3011", "\u3042\u3060\u540d\u3092\u547d\u540d\u3057\u3066\u3082\u3089\u3063\u305f\u30d6\u30bf\uff08\u30e1\u30b9\uff09", "\u3060\u304c\u672c\u4eba\u306f\u3053\u306e\u540d\u524d\u306b\u7d0d\u5f97\u306f\u3057\u3066\u3044\u306a\u3044\u3002", "\u4f53\u306e\u8d64\u3044\u8272\u306f\u65e5\u713c\u3051\u3067\u3042\u308b\u3002", "\u672c\u540d\u306f\u30a8\u30ea\u30b6\u30d9\u30b9\u3002\u30a4\u30ae\u30ea\u30b9\u751f\u307e\u308c\u3002" }, { "\u3010\u30b8\u30e3\u30c3\u30ad\u30fc\u30fb\u30da\u30f3\u3011", "\u30ab\u30f3\u30d5\u30fc\u6620\u753b\u306b\u3042\u3053\u304c\u308c\u3066\u3001", "\u6211\u6d41\u3067\u30ab\u30f3\u30d5\u30fc\u3092\u59cb\u3081\u305f\u30da\u30f3\u30ae\u30f3\u3002", "\u30cf\u30ea\u30a6\u30c3\u30c9\u30c7\u30d3\u30e5\u30fc\u3092\u76ee\u6307\u3057\u3066", "\u65e5\u3005\u4fee\u884c\u306b\u660e\u3051\u66ae\u308c\u308b\u3002" }, { "\u3010\u30b4\u30ea\u3055\u3093\u3011", "\u9854\u304c\u30b3\u30ef\u30a4\u3002\u3068\u3044\u3046\u7406\u7531\u3067\u52d5\u7269\u5712\u3092", "\u8ffd\u653e\u3055\u308c\u305f\u30cb\u30fc\u30c8\u30b4\u30ea\u30e9\u3002", "\u30cb\u30fc\u30c8\u306b\u306a\u3063\u3066\u304b\u3089\u306f\u304a\u9152\u3068\u30ae\u30e3\u30f3\u30d6\u30eb", "\u306b\u304a\u307c\u308c\u308b\u65e5\u3005\u304c\u7d9a\u304f\u3002" }, { "\u3010\u30e1\u30a7\u30e1\u30a7\u3011", "\u30d9\u30bf\u306a\u540d\u524d\u306b\u30d9\u30bf\u306a\u59ff\u3002", "\u666e\u901a\u3059\u304e\u308b\u3053\u3068\u304c\u30b3\u30f3\u30d7\u30ec\u30c3\u30af\u30b9\u306a\u7f8a\u3002", "\u3044\u3064\u304b\u500b\u6027\u7684\u306a\u30ad\u30e3\u30e9\u306b\u306a\u3063\u3066\u3084\u308b\u3093\u3060\u3068", "\u610f\u6c17\u8fbc\u3093\u3067\u304a\u7b11\u3044\u30b9\u30af\u30fc\u30eb\u306b\u901a\u3063\u3066\u3044\u308b\u3002" }, { "\u3010\u30b4\u30de\u3055\u307e\u3011", "\u3061\u307e\u305f\u3067\u30a6\u30ef\u30b5\u306e\u30a2\u30b6\u30e9\u30b7\u306b\u61a7\u308c\u3066", "\u4e0a\u4eac\u3057\u3066\u304d\u305f\u30a2\u30b6\u30e9\u30b7\u3002", "\u30c1\u30e4\u30db\u30e4\u3055\u308c\u305f\u3044\u306e\u306b\u306a\u304b\u306a\u304b", "\u6ce8\u76ee\u3055\u308c\u306a\u3044\u306e\u3067\u4f53\u3092\u8d64\u304f\u67d3\u3081\u3066\u307f\u305f\u3002" }, { "\u3010\u30d1\u30aa\u30f3\u3011", "\u9577\u3044\u30ea\u30fc\u30c1\u3092\u751f\u304b\u3057\u305f\u653b\u6483\u304c\u7279\u5fb4\u7684\u306a\u8c61\u3002", "\u597d\u304d\u306a\u30bf\u30a4\u30d7\u306f\u307d\u3063\u3061\u3083\u308a\u76ee\u306e\u5de8\u4e73\u3002", "\u30b0\u30e9\u30d3\u30a2\u306e\u5199\u771f\u96c6\u3092\u96c6\u3081\u308b\u306e\u304c\u8da3\u5473\u3002", "\u79d8\u8535\u306e\u30b3\u30ec\u30af\u30b7\u30e7\u30f3\u306f\u6570\u77e5\u308c\u305a\u3002" }, { "\u3010\u30ab\u30fb\u30f3\u30ac\u30ea\u30e5\u3011", "\u6614\u8aad\u3093\u3060\u30de\u30f3\u30ac\u304c\u304d\u3063\u304b\u3051\u3067\u30dc\u30af\u30b7\u30f3\u30b0\u3092", "\u59cb\u3081\u308b\u3002\u30e9\u30a4\u30bb\u30f3\u30b9\u8a66\u9a13\u3067\u30ab\u30f3\u30ac\u30eb\u30fc\u3068", "\u3044\u3046\u7406\u7531\u3060\u3051\u3067\u843d\u3068\u3055\u308c\u3001\u4eba\u751f\u304c\u771f\u3063\u767d\u306b", "\u71c3\u3048\u5c3d\u304d\u305f\u60b2\u5287\u306e\u30ab\u30f3\u30ac\u30eb\u30fc\u3002" }, { "\u3010\u4e00\u89d2\u304f\u3093\u3011", "\u4eba\u3092\u52a9\u3051\u308b\u4ed5\u4e8b\u3092\u3057\u305f\u304f\u3066\u6d88\u9632\u7f72\u3067", "\u50cd\u3044\u3066\u3044\u308b\u3002\u6d88\u9632\u8eca\u306e\u304b\u308f\u308a\u306b\u4eba\u3092\u4e57\u305b\u3066", "\u51fa\u52d5\u3059\u308b\u3053\u3068\u3082\u3042\u308b\u304c\u3001\u8db3\u304c\u9045\u3044\u306e\u3067", "\u5230\u7740\u3059\u308b\u9803\u306b\u306f\u5bb6\u304c\u307b\u307c\u71c3\u3048\u5c3d\u304d\u3066\u3044\u308b\u3002" }, { "\u3010\u30af\u30de\u5148\u751f\u3011", "\u5e7c\u7a1a\u5712\u306e\u5148\u751f\u3002\u7b11\u9854\u3067\u632f\u308a\u4e0b\u308d\u3055\u308c\u308b", "\u30b3\u30d6\u30b7\u306f\u3081\u3063\u3061\u3083\u75db\u3044\u3002", "\u6012\u308b\u3068\u6016\u3044\u304c\u6e29\u539a\u306a\u305d\u306e\u6027\u683c\u3067\u5712\u5150\u305f\u3061\u306b", "\u30af\u30de\u5148\u751f\u306e\u611b\u79f0\u3067\u6155\u308f\u308c\u3066\u3044\u308b\u3002" }, { "\u3010\u30ef\u30cb\u30c3\u30af\u3011", "\u30ef\u30cb\u76ae\u306e\u30d6\u30e9\u30f3\u30c9\u54c1\u306b\u306a\u308a\u304b\u3051\u305f\u3068\u3053\u308d\u3092", "\u30c0\u30f3\u30c7\u30a3\u30fc\u306a\u4eba\u306b\u52a9\u3051\u3089\u308c\u305f\u30ef\u30cb\u3002", "\u901a\u4fe1\u6559\u80b2\u3067\u69d8\u3005\u306a\u8cc7\u683c\u3092\u53d6\u5f97\u3057\u3066\u3044\u308b", "\u8cc7\u683c\u30de\u30cb\u30a2\u3002\u30ef\u30fc\u30d7\u30ed\u691c\u5b9a2\u7d1a\u3002" }, { "\u3010\u30a6\u30b5\u9280\u3011", "\u898b\u305f\u76ee\u4ee5\u4e0a\u306b\u300c\u3044\u3076\u3057\u304e\u3093\u300d\u306a\u30a6\u30b5\u30ae\u3002", "\u5927\u624b\u5546\u793e\u3092\u3084\u3081\u3066\u72ec\u7acb\u3002", "\u73fe\u5728\uff14\u3064\u306e\u4f1a\u793e\u3092\u7d4c\u55b6\u3057\u3066\u3044\u308b\u3002", "\u5c06\u6765\u306f\u5e02\u9577\u306e\u5ea7\u3092\u72d9\u3063\u3066\u3044\u308b\u3002" }, { "\u3010\u30ea\u30c3\u30b9\u30f3\u30c8\u30a5\u30df\u30fc\u3011", "\u72ec\u81ea\u3067\u7de8\u307f\u51fa\u3057\u305f\u82f1\u8a9e\u3092\u3057\u3083\u3079\u308b\u30ea\u30b9\u3002", "\u767a\u97f3\u306f\u306a\u3093\u3060\u304b\u82f1\u8a9e\u3063\u307d\u3044\u3051\u3069\u3082", "\u4f55\u3092\u8a00\u3063\u3066\u3044\u308b\u306e\u304b\u308f\u304b\u3089\u306a\u3044\u3002", "\u666e\u6bb5\u306f\u99c5\u524d\u306e\u82f1\u8a9e\u6559\u5ba4\u3067\u8b1b\u5e2b\u3092\u52d9\u3081\u308b\u3002" }, { "\u3010\u30d6\u30e9\u30c3\u30af\u30de\u3011", "\u95c7\u306e\u4e16\u754c\u3067\u751f\u304d\u3066\u304d\u305f\u6697\u6bba\u718a\u3002\u3053\u306e\u4e0d\u6cc1\u3067", "\u6bba\u3057\u306e\u4f9d\u983c\u3082\u6fc0\u6e1b\u3002\uff11\u6bba\u3001\uff11\u5104\u3067\u4f9d\u983c\u3092", "\u52df\u96c6\u4e2d\u3002\u3068\u3001\u4eca\u671d\u306e\u6298\u308a\u8fbc\u307f\u30c1\u30e9\u30b7\u306b", "\u66f8\u3044\u3066\u3042\u3063\u305f\u3002" }, { "\u3010\u8d64\u7f85\u6211\u738b\u3011", "\u4eba\u524d\u306b\u3067\u308b\u3068\u8d64\u9762\u3057\u3061\u3083\u3046\u8d85\u7167\u308c\u5c4b\u3055\u3093\u3002", "\u30ab\u30e9\u30aa\u30b1\u3067\u306e\u6b4c\u58f0\u306f\u30d7\u30ed\u7d1a\u3060\u304c\u4eba\u524d\u3067\u306f", "\u6b4c\u3063\u305f\u3053\u3068\u304c\u7121\u3044\u3002", "\u8da3\u5473\u306f\u3082\u3061\u308d\u3093\u4e00\u4eba\u30ab\u30e9\u30aa\u30b1\u3002" }, { "\u3010\u30ab\u30aa\u30eb\u541b\u3011", "\u30c0\u30a4\u30a8\u30c3\u30c8\u306e\u3057\u3059\u304e\u3067\u9854\u3060\u3051\u306b\u306a\u3063\u3066", "\u3057\u307e\u3063\u305f\u30ab\u30aa\u30eb\u541b\u3002\u4f53\u304c\u7121\u304f\u306a\u3063\u305f\u305b\u3044\u3067", "\u9854\u304c\u80a5\u5927\u5316\u3057\u3001\u30c0\u30a4\u30a8\u30c3\u30c8\u524d\u3088\u308a\u3082\u4f53\u91cd\u304c", "\u91cd\u304f\u306a\u3063\u305f\u3002\u306a\u306e\u3067\u6d6e\u3044\u3066\u307f\u305f\u3002" }, { "\u3010\u9ed2\u72ac\uff11\u3011", "", "", "", "" }, { "\u3010\u9ed2\u72ac\uff12\u3011", "", "", "", "" }, { "\u3010\u30ab\u30f3\u30d0\u30f3\u5a18\u3011", "\u3042\u307e\u308a\u306b\u3082\u6642\u9593\u304c\u304b\u304b\u308a\u3059\u304e\u308b\u3068\u51fa\u73fe\u3059\u308b", "\u3054\u8fd1\u6240\u3067\u3082\u8a55\u5224\u306e\u30e0\u30b9\u30e1\u3055\u3093\u3002", "\u5c06\u6765\u306e\u5922\u306f\u304a\u5ac1\u3055\u3093\u3002", "\u5bb6\u65cf\u69cb\u6210\u306f\u3001\u7236\u3001\u6bcd\u3001\u5144\u3002\u3042\u3068\u30d1\u30d1\u3002" }, { "\u3010\u30ac\u30ac\u30ac\u30ac\u3011", "\u81ea\u5206\u306f\u5c06\u6765\u7f8e\u3057\u3044\u30c1\u30e7\u30a6\u306b\u306a\u308b\u3093\u3060\u3068", "\u671f\u5f85\u3057\u3066\u30b5\u30ca\u30ae\u304b\u3089\u51fa\u3066\u304d\u305f\u3089\u3001", "\u300c\u30ac\u300d\u3060\u3063\u305f\u3053\u3068\u306b\u30b7\u30e7\u30c3\u30af\u3092\u53d7\u3051\u308b\u3002", "\u3050\u308c\u305f\u6642\u671f\u3082\u3042\u3063\u305f\u304c\u73fe\u5728\u306f\u66f4\u751f\u3057\u3066\u3044\u308b\u3002" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" }, { "\u3010\u30c0\u30df\u30fc\u3011", "", "", "", "" } };
        this.zukan4 = new int[] { 0, 3, 5, 6, 6, 5, 3 };
        this.cos_tbl = new int[] { 4096, 4096, 4095, 4093, 4091, 4088, 4085, 4081, 4076, 4071, 4065, 4059, 4052, 4044, 4036, 4027, 4017, 4007, 3996, 3985, 3973, 3961, 3948, 3934, 3920, 3905, 3889, 3873, 3857, 3839, 3822, 3803, 3784, 3765, 3745, 3724, 3703, 3681, 3659, 3636, 3612, 3588, 3564, 3539, 3513, 3487, 3461, 3433, 3406, 3378, 3349, 3320, 3290, 3260, 3229, 3198, 3166, 3134, 3102, 3068, 3035, 3001, 2967, 2932, 2896, 2861, 2824, 2788, 2751, 2713, 2675, 2637, 2598, 2559, 2520, 2480, 2440, 2399, 2359, 2317, 2276, 2234, 2191, 2149, 2106, 2062, 2019, 1975, 1931, 1886, 1842, 1797, 1751, 1706, 1660, 1614, 1567, 1521, 1474, 1427, 1380, 1332, 1285, 1237, 1189, 1141, 1092, 1044, 995, 946, 897, 848, 799, 750, 700, 651, 601, 551, 501, 451, 401, 351, 301, 251, 201, 151, 101, 50, 0 };
        MyCanvas.font[0] = Font.getFont(1879048704);
        MyCanvas.font[1] = Font.getFont(1879049216);
        MyCanvas.font[2] = Font.getFont(1879048448);
        for (int i = 0; i < MyCanvas.cfg_vol.length; ++i) {
            if (i * 5 < 10) {
                MyCanvas.cfg_vol[i] = "  " + i * 5;
            }
            else if (i + 5 < 100) {
                MyCanvas.cfg_vol[i] = " " + i * 5;
            }
            else {
                MyCanvas.cfg_vol[i] = "100";
            }
        }
        PhoneSystem.setAttribute(0, 1);
        MyCanvas.platform = System.getProperty("microedition.platform");
        if (MyCanvas.platform.indexOf("ap") == 0) {
            MyCanvas.sivar[10] = 1;
        }
        try {
            (MyCanvas.media = MediaManager.getImage("resource:///load.gif")).use();
            MyCanvas.load_img = MyCanvas.media.getImage();
        }
        catch (final Exception ex) {}
        try {
            (MyCanvas.media = MediaManager.getImage("resource:///0.gif")).use();
            MyCanvas.wakuimg = MyCanvas.media.getImage();
        }
        catch (final Exception ex2) {}
        MyCanvas.sivar[16] = 1;
        MyCanvas.sivar[5] = 2;
        MyCanvas.sivar[4] = 15;
        MyCanvas.pri[0] = new PrimitiveArray(4, 1024, 1);
        MyCanvas.pri[1] = new PrimitiveArray(4, 1792, 1);
        MyCanvas.pri[2] = new PrimitiveArray(4, 12800, 20);
        for (int j = 0; j < 9; ++j) {
            this.unit_read(j);
        }
        this.t_unit_read();
        this.cal = Calendar.getInstance();
        this.nen = this.cal.get(1);
    }
    
    public void run() {
        final int[] array = new int[8];
        final int[] array2 = new int[8];
        final String[] array3 = new String[4];
        MyCanvas.g = this.getGraphics();
        MyCanvas.g3d = (Graphics3D)MyCanvas.g;
        while (true) {
            MyCanvas.sivar[13] = MyCanvas.sivar[14];
            MyCanvas.sivar[14] = 0;
            MyCanvas.sivar[15] = this.getKeypadState();
            if (MyCanvas.wnd_param[6][1] == 0) {
                final int[] sivar = MyCanvas.sivar;
                final int n = 9;
                sivar[n] += 2 / MyCanvas.sivar[5];
            }
            if (MyCanvas.snd_val[1] != 0) {
                if (MyCanvas.snd_val[4] != 0) {
                    this.play(-3);
                    MyCanvas.snd_val[4] = 0;
                }
                for (int i = 0; i < MyCanvas.snd_val[0]; ++i) {
                    if (MyCanvas.snd_data[3][i] != -1) {
                        MyCanvas.snd_data[10][i] = MyCanvas.snd_data[3][i];
                        MyCanvas.snd_data[11][i] = MyCanvas.snd_data[4][i];
                        MyCanvas.snd_data[12][i] = MyCanvas.snd_data[7][i];
                        MyCanvas.snd_data[13][i] = MyCanvas.snd_data[8][i];
                        MyCanvas.snd_data[14][i] = MyCanvas.audio[i].getCurrentTime();
                    }
                    else {
                        MyCanvas.snd_data[10][i] = -1;
                    }
                }
            }
            switch (MyCanvas.sivar[0]) {
                case 100: {
                    final int[] p_flg = this.p_flg;
                    final int n2 = 17;
                    ++p_flg[n2];
                    if (this.p_flg[0] == 0) {
                        final int[] p_flg2 = this.p_flg;
                        final int n3 = 1;
                        ++p_flg2[n3];
                        if (this.p_flg[1] >= this.t_ani1.length) {
                            this.p_flg[0] = 1;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                            this.p_flg[3] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 1) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg3 = this.p_flg;
                        final int n4 = 1;
                        ++p_flg3[n4];
                        if (this.p_flg[1] >= this.t_ani2.length) {
                            this.p_flg[0] = 2;
                            this.p_flg[1] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 2) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                            if (this.p_flg[2] == 0) {
                                this.p_flg[2] = 3;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[2] = 0;
                            }
                            else if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 1;
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 1;
                            }
                            this.play(10);
                        }
                        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                            if (this.p_flg[2] == 0) {
                                this.p_flg[2] = 1;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[2] = 2;
                            }
                            else if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 3;
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 0;
                            }
                            this.play(10);
                        }
                        else if ((MyCanvas.sivar[13] & 0x50050) != 0x0) {
                            if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 3;
                                this.play(10);
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 2;
                                this.play(10);
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            if (this.p_flg[2] == 0) {
                                for (int j = 0; j < this.save1.length; ++j) {
                                    this.save3[j] = this.save1[j];
                                }
                                for (int k = 0; k < this.save2.length; ++k) {
                                    this.save4[k] = this.save2[k];
                                }
                                for (int l = 0; l < this.save5.length; ++l) {
                                    this.save6[l] = this.save5[l];
                                }
                                this.takara_s();
                                this.p_flg[0] = 3;
                                this.p_flg[1] = 0;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[0] = 5;
                                this.p_flg[1] = 0;
                            }
                            else if (this.p_flg[2] == 2) {
                                this.setScene(154);
                            }
                            else if (this.p_flg[2] == 3) {
                                this.setScene(153);
                            }
                            this.play(11);
                        }
                        else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.setScene(150);
                            this.play(11);
                        }
                    }
                    else if (this.p_flg[0] == 3) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg4 = this.p_flg;
                        final int n5 = 1;
                        ++p_flg4[n5];
                        if (this.p_flg[1] >= this.t_ani3.length) {
                            this.p_flg[0] = 10;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                            if (this.save3[1] == 0 && this.save0[0] == 0) {
                                this.p_flg[24] = 0;
                                this.p_flg[25] = 1;
                            }
                            else if (this.save3[1] != 0 && this.save0[0] == 0) {
                                this.p_flg[24] = 1;
                                this.p_flg[25] = 2;
                            }
                            else if (this.save3[1] == 0 && this.save0[0] != 0) {
                                this.p_flg[24] = 2;
                                this.p_flg[25] = 2;
                            }
                            else {
                                this.p_flg[24] = 3;
                                this.p_flg[25] = 3;
                            }
                        }
                    }
                    else if (this.p_flg[0] == 4) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg5 = this.p_flg;
                        final int n6 = 1;
                        ++p_flg5[n6];
                        if (this.p_flg[1] >= this.t_ani2.length) {
                            this.p_flg[0] = 2;
                            this.setSoftLabel(this.p_flg[1] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                        }
                    }
                    else if (this.p_flg[0] == 5) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg6 = this.p_flg;
                        final int n7 = 1;
                        ++p_flg6[n7];
                        if (this.p_flg[1] >= 11) {
                            this.p_flg[0] = 50;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                            this.g_load(58 + this.zukan1[this.p_flg[2]]);
                            MyCanvas.slvar[0] = 0L;
                            this.uni[1][0][0] = this.zukan1[this.p_flg[2]];
                            this.uni[1][0][1] = 0;
                            this.uni[1][0][2] = 0;
                            this.setSoftLabel(this.uni[1][0][3] = 0, MyCanvas.soft_label[0] = "\u623b\u308b");
                        }
                    }
                    else if (this.p_flg[0] == 10) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg7 = this.p_flg;
                        final int n8 = 1;
                        ++p_flg7[n8];
                        if (this.p_flg[1] >= this.t_ani2.length) {
                            this.p_flg[0] = 11;
                            this.setSoftLabel(this.p_flg[1] = 0, MyCanvas.soft_label[0] = "\u623b\u308b");
                        }
                    }
                    else if (this.p_flg[0] == 11) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                            this.play(10);
                            this.p_flg[2] = (this.p_flg[2] - 1 + this.p_flg[25]) % this.p_flg[25];
                        }
                        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                            this.play(10);
                            this.p_flg[2] = (this.p_flg[2] + 1) % this.p_flg[25];
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            int n9 = 1;
                            if (this.p_flg[24] == 1) {
                                if (this.p_flg[2] == 0) {
                                    n9 = 0;
                                }
                            }
                            else if (this.p_flg[24] == 2) {
                                if (this.p_flg[2] == 1) {
                                    n9 = 2;
                                }
                            }
                            else if (this.p_flg[24] == 3) {
                                n9 = this.p_flg[2];
                            }
                            if (n9 == 0) {
                                this.p_flg[0] = 31;
                                this.p_flg[1] = 0;
                                this.play(-2);
                                this.play(13);
                            }
                            else if (n9 == 1) {
                                this.p_flg[0] = 30;
                                this.p_flg[1] = 0;
                                this.play(-2);
                                this.play(13);
                            }
                            else if (n9 == 2) {
                                this.p_flg[0] = 12;
                                this.p_flg[1] = 0;
                                this.play(11);
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.p_flg[0] = 13;
                            this.p_flg[1] = 0;
                            this.play(12);
                        }
                    }
                    else if (this.p_flg[0] == 12) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg8 = this.p_flg;
                        final int n10 = 1;
                        ++p_flg8[n10];
                        if (this.p_flg[1] >= this.t_ani3.length) {
                            this.p_flg[0] = 20;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 13) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg9 = this.p_flg;
                        final int n11 = 1;
                        ++p_flg9[n11];
                        if (this.p_flg[1] >= this.t_ani3.length) {
                            this.p_flg[0] = 4;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 14) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg10 = this.p_flg;
                        final int n12 = 1;
                        ++p_flg10[n12];
                        if (this.p_flg[1] >= this.t_ani2.length) {
                            this.p_flg[0] = 11;
                            this.p_flg[1] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 20) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg11 = this.p_flg;
                        final int n13 = 1;
                        ++p_flg11[n13];
                        if (this.p_flg[1] >= this.t_ani2.length) {
                            this.p_flg[0] = 21;
                            this.p_flg[1] = 0;
                            this.p_flg[26] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 21) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if (this.p_flg[26] > 0) {
                            final int[] p_flg12 = this.p_flg;
                            final int n14 = 26;
                            --p_flg12[n14];
                        }
                        if ((MyCanvas.sivar[13] & 0x50050) != 0x0) {
                            this.play(10);
                            this.p_flg[2] = (this.p_flg[2] + 1) % 2;
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            if (this.p_flg[2] == 0) {
                                this.p_flg[0] = 23;
                                this.p_flg[1] = 0;
                                this.play(7);
                                this.p_flg[4] = 1;
                                this.p_flg[5] = 0;
                                this.p_flg[6] = 0;
                            }
                            else {
                                this.setScene(250);
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.play(12);
                            this.p_flg[0] = 22;
                            this.p_flg[1] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 22) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg13 = this.p_flg;
                        final int n15 = 1;
                        ++p_flg13[n15];
                        if (this.p_flg[1] >= this.t_ani3.length) {
                            this.p_flg[0] = 14;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 2;
                            this.p_flg[3] = 2;
                            this.p_flg[24] = 3;
                            this.p_flg[25] = 3;
                        }
                    }
                    else if (this.p_flg[0] == 23) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg14 = this.p_flg;
                        final int n16 = 1;
                        ++p_flg14[n16];
                        if (this.p_flg[1] >= this.kiri_tbl3.length) {
                            this.p_flg[0] = 24;
                            this.p_flg[1] = 0;
                            this.p_flg[4] = 3;
                            this.p_flg[5] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 24) {
                        final int[] p_flg15 = this.p_flg;
                        final int n17 = 1;
                        ++p_flg15[n17];
                        if (this.p_flg[1] == 15) {
                            for (int n18 = 0; n18 < MyCanvas.img.length; ++n18) {
                                if (MyCanvas.bunrui[n18] == 1 || MyCanvas.bunrui[n18] == 3) {
                                    this.g_free(n18);
                                }
                            }
                            for (int n19 = 0; n19 < MyCanvas.img.length; ++n19) {
                                if (MyCanvas.bunrui[n19] == 2) {
                                    this.g_load(n19);
                                }
                            }
                            for (int n20 = 0; n20 < this.p_flg.length; ++n20) {
                                this.p_flg[n20] = 0;
                            }
                            this.p_flg[0] = 48;
                            this.st_s();
                            this.p_flg[14] = 3;
                            this.p_flg[15] = 0;
                            this.p_flg[16] = 0;
                            this.setScene(400);
                            MyCanvas.slvar[0] = 0L;
                        }
                    }
                    else if (this.p_flg[0] >= 30 && this.p_flg[0] <= 31) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg16 = this.p_flg;
                        final int n21 = 1;
                        ++p_flg16[n21];
                        if (this.p_flg[1] >= 16) {
                            for (int n22 = 1; n22 < this.p_flg.length; ++n22) {
                                this.p_flg[n22] = 0;
                            }
                            this.p_flg[4] = 1;
                            this.syoki_iti = -1;
                            if (this.p_flg[0] == 30) {
                                for (int n23 = 0; n23 < this.save3.length; ++n23) {
                                    this.save3[n23] = 0;
                                }
                                for (int n24 = 0; n24 < this.save4.length; ++n24) {
                                    this.save4[n24] = 0;
                                }
                                for (int n25 = 0; n25 < this.save6.length; ++n25) {
                                    this.save6[n25] = 0;
                                }
                                this.takara_s();
                                this.save3[13] = 1;
                                this.p_flg[2] = this.save3[1];
                                while (this.tizu3[this.p_flg[16]] != this.p_flg[2]) {
                                    final int[] p_flg17 = this.p_flg;
                                    final int n26 = 16;
                                    ++p_flg17[n26];
                                }
                                final int n27 = this.p_flg[16];
                                int n28 = 94 - (this.tizu1[n27 * 6 + 4] + this.tizu1[n27 * 6 + 2] / 2);
                                int n29 = 112 - (this.tizu1[n27 * 6 + 5] + this.tizu1[n27 * 6 + 3] / 2);
                                if (this.random(100) < 50) {
                                    n28 += 300;
                                }
                                else {
                                    n28 -= 300;
                                }
                                if (this.random(100) < 50) {
                                    n29 += 300;
                                }
                                else {
                                    n29 -= 300;
                                }
                                this.p_flg[9] = n28;
                                this.p_flg[10] = n29;
                                this.p_flg[15] = 0;
                                this.p_flg[0] = 130;
                                this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff80\uff72\uff84\uff99");
                            }
                            else if (this.p_flg[0] == 31) {
                                this.p_flg[0] = 100;
                                this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                            }
                            this.p_flg[22] = this.save3[0];
                            this.play(2);
                        }
                    }
                    else if (this.p_flg[0] == 50 || this.p_flg[0] == 51) {
                        this.uni_a2(0);
                        if (this.uni[1][0][1] == 0) {
                            if (this.uni[1][0][2] == 0) {
                                final int[] array4 = this.uni[1][0];
                                final int n30 = 3;
                                ++array4[n30];
                                if (this.uni[1][0][3] >= 3) {
                                    this.uni[1][0][1] = 1;
                                    this.uni[1][0][2] = 0;
                                    this.uni[1][0][3] = 0;
                                }
                            }
                        }
                        else if (this.uni[1][0][1] == 1) {
                            final int[] array5 = this.uni[1][0];
                            final int n31 = 3;
                            ++array5[n31];
                            if (this.uni[1][0][3] >= 10) {
                                this.uni[1][0][1] = 2;
                                this.uni[1][0][2] = 1;
                                this.uni[1][0][3] = 0;
                            }
                        }
                        else if (this.uni[1][0][1] == 2 && this.uni[1][0][2] == 0) {
                            final int[] array6 = this.uni[1][0];
                            final int n32 = 3;
                            ++array6[n32];
                            if (this.uni[1][0][3] >= 1) {
                                this.uni[1][0][1] = 0;
                                this.uni[1][0][2] = 0;
                                this.uni[1][0][3] = 0;
                            }
                        }
                        if (this.p_flg[0] == 50) {
                            if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                                this.play(10);
                                this.g_free(58 + this.zukan1[this.p_flg[2]]);
                                this.p_flg[2] = (this.p_flg[2] - 1 + this.zukan1.length) % this.zukan1.length;
                                if (this.save0[4 + this.zukan1[this.p_flg[2]] - 2] != 0) {
                                    this.g_load(58 + this.zukan1[this.p_flg[2]]);
                                }
                                MyCanvas.slvar[0] = 0L;
                                this.uni[1][0][0] = this.zukan1[this.p_flg[2]];
                                this.uni[1][0][1] = 0;
                                this.uni[1][0][2] = 0;
                                this.uni[1][0][3] = 0;
                            }
                            else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                                this.play(10);
                                this.g_free(58 + this.zukan1[this.p_flg[2]]);
                                this.p_flg[2] = (this.p_flg[2] + 1) % this.zukan1.length;
                                if (this.save0[4 + this.zukan1[this.p_flg[2]] - 2] != 0) {
                                    this.g_load(58 + this.zukan1[this.p_flg[2]]);
                                }
                                MyCanvas.slvar[0] = 0L;
                                this.uni[1][0][0] = this.zukan1[this.p_flg[2]];
                                this.uni[1][0][1] = 0;
                                this.uni[1][0][2] = 0;
                                this.uni[1][0][3] = 0;
                                MyCanvas.slvar[0] = 0L;
                            }
                            else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                                this.p_flg[0] = 51;
                                this.p_flg[1] = 0;
                                this.play(11);
                            }
                        }
                        else if (this.p_flg[0] == 51) {
                            final int[] p_flg18 = this.p_flg;
                            final int n33 = 1;
                            ++p_flg18[n33];
                            if (this.p_flg[1] >= 11) {
                                this.p_flg[0] = 2;
                                this.p_flg[1] = 0;
                                this.p_flg[2] = 1;
                                for (int n34 = 0; n34 < MyCanvas.img.length; ++n34) {
                                    if (MyCanvas.bunrui[n34] == 3) {
                                        this.g_free(n34);
                                    }
                                }
                                MyCanvas.slvar[0] = 0L;
                                this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                            }
                        }
                    }
                    else if (this.p_flg[0] == 100) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                            this.play(10);
                            if (this.p_flg[2] == 0) {
                                this.p_flg[2] = 3;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[2] = 0;
                            }
                            else if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 1;
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 1;
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                            this.play(10);
                            if (this.p_flg[2] == 0) {
                                this.p_flg[2] = 1;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[2] = 2;
                            }
                            else if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 3;
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 0;
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x50050) != 0x0) {
                            if (this.p_flg[2] == 2) {
                                this.p_flg[2] = 3;
                                this.play(10);
                            }
                            else if (this.p_flg[2] == 3) {
                                this.p_flg[2] = 2;
                                this.play(10);
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            if (this.p_flg[2] == 0) {
                                this.p_flg[0] = 110;
                                this.p_flg[1] = 0;
                                if (this.syoki_iti == -1) {
                                    this.p_flg[2] = this.save3[1];
                                }
                                else {
                                    this.p_flg[2] = this.syoki_iti;
                                }
                                if (this.p_flg[2] > 47) {
                                    this.p_flg[2] = 47;
                                }
                                this.p_flg[16] = 0;
                                while (this.tizu3[this.p_flg[16]] != this.p_flg[2]) {
                                    final int[] p_flg19 = this.p_flg;
                                    final int n35 = 16;
                                    ++p_flg19[n35];
                                }
                                final int n36 = this.p_flg[16];
                                int n37 = 94 - (this.tizu1[n36 * 6 + 4] + this.tizu1[n36 * 6 + 2] / 2);
                                int n38 = 112 - (this.tizu1[n36 * 6 + 5] + this.tizu1[n36 * 6 + 3] / 2);
                                if (this.random(100) < 50) {
                                    n37 += 300;
                                }
                                else {
                                    n37 -= 300;
                                }
                                if (this.random(100) < 50) {
                                    n38 += 300;
                                }
                                else {
                                    n38 -= 300;
                                }
                                this.p_flg[9] = n37;
                                this.p_flg[10] = n38;
                                this.p_flg[15] = 0;
                            }
                            else if (this.p_flg[2] == 1) {
                                this.p_flg[0] = 200;
                                this.p_flg[1] = 0;
                                this.p_flg[2] = 1;
                                this.p_flg[4] = 4;
                                this.p_flg[5] = this.n_tbl1.length - 1;
                                this.p_flg[20] = 0;
                                this.p_flg[21] = 0;
                                this.c_dai[0] = (this.c_dai[1] = 0);
                            }
                            else if (this.p_flg[2] == 2) {
                                this.p_flg[0] = 300;
                                this.p_flg[1] = 0;
                                this.p_flg[2] = 0;
                                this.p_flg[18] = 0;
                                this.p_flg[19] = 0;
                                this.p_flg[4] = 4;
                                this.p_flg[5] = this.n_tbl1.length - 1;
                            }
                            else if (this.p_flg[2] == 3) {
                                this.setScene(158);
                            }
                            this.play(11);
                        }
                        else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.setScene(155);
                            this.play(11);
                        }
                    }
                    else if (this.p_flg[0] == 110 || this.p_flg[0] == 200 || this.p_flg[0] == 300) {
                        if (this.p_flg[0] == 110) {
                            this.p_flg[7] = (this.p_flg[7] + 1) % 240;
                            this.p_flg[8] = (this.p_flg[8] + 1) % 240;
                            this.tizu_s();
                        }
                        final int[] p_flg20 = this.p_flg;
                        final int n39 = 1;
                        ++p_flg20[n39];
                        if (this.p_flg[1] == this.fusuma1.length) {
                            if (this.p_flg[0] == 110) {
                                this.p_flg[0] = 120;
                            }
                            else if (this.p_flg[0] == 200) {
                                this.p_flg[0] = 210;
                            }
                            else {
                                this.p_flg[0] = 310;
                            }
                            this.p_flg[1] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 115 || this.p_flg[0] == 240 || this.p_flg[0] == 340) {
                        if (this.p_flg[0] == 115) {
                            this.p_flg[7] = (this.p_flg[7] + 1) % 240;
                            this.p_flg[8] = (this.p_flg[8] + 1) % 240;
                            this.tizu_s();
                        }
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg21 = this.p_flg;
                        final int n40 = 1;
                        --p_flg21[n40];
                        if (this.p_flg[1] < 0) {
                            if (this.p_flg[0] == 115) {
                                this.p_flg[2] = 0;
                            }
                            else if (this.p_flg[0] == 240) {
                                this.p_flg[2] = 1;
                            }
                            else {
                                this.p_flg[2] = 2;
                            }
                            this.p_flg[0] = 100;
                            this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                        }
                    }
                    else if (this.p_flg[0] == 120 || this.p_flg[0] == 210 || this.p_flg[0] == 310) {
                        if (this.p_flg[0] == 120) {
                            this.p_flg[7] = (this.p_flg[7] + 1) % 240;
                            this.p_flg[8] = (this.p_flg[8] + 1) % 240;
                            this.tizu_s();
                        }
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg22 = this.p_flg;
                        final int n41 = 1;
                        ++p_flg22[n41];
                        if (this.p_flg[1] == this.fusuma2.length) {
                            if (this.p_flg[0] == 120) {
                                this.p_flg[0] = 130;
                            }
                            else if (this.p_flg[0] == 210) {
                                this.p_flg[0] = 220;
                                this.p_flg[27] = 0;
                            }
                            else {
                                this.p_flg[0] = 320;
                            }
                            this.setSoftLabel(this.p_flg[1] = 0, MyCanvas.soft_label[0] = "\u623b\u308b");
                        }
                    }
                    else if (this.p_flg[0] == 130) {
                        this.p_flg[7] = (this.p_flg[7] + 1) % 240;
                        this.p_flg[8] = (this.p_flg[8] + 1) % 240;
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int n42 = this.p_flg[2] % 6;
                        int n43 = this.p_flg[2] / 6;
                        int n44 = this.save3[1];
                        if (n44 > 47) {
                            n44 = 47;
                        }
                        final int n45 = this.p_flg[2];
                        if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                            final int[] p_flg23 = this.p_flg;
                            final int n46 = 2;
                            --p_flg23[n46];
                            if (this.p_flg[2] < 0) {
                                this.p_flg[2] = n44;
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                            final int[] p_flg24 = this.p_flg;
                            final int n47 = 2;
                            ++p_flg24[n47];
                            if (this.p_flg[2] > n44) {
                                this.p_flg[2] = 0;
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                            if (--n43 < 0) {
                                n43 = n44 / 6;
                            }
                            this.p_flg[2] = n43 * 6 + n42;
                            if (this.p_flg[2] > n44) {
                                this.p_flg[2] = n44;
                            }
                        }
                        else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                            if (++n43 > n44 / 6) {
                                n43 = 0;
                            }
                            this.p_flg[2] = n43 * 6 + n42;
                            if (this.p_flg[2] > n44) {
                                this.p_flg[2] = n44;
                            }
                        }
                        if (n45 == this.p_flg[2]) {
                            if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                                if (this.p_flg[15] >= this.tizu4.length - 1) {
                                    if (this.taiken_flg == 1 && this.p_flg[2] >= 7) {
                                        this.setScene(160);
                                        this.play(11);
                                    }
                                    else {
                                        this.play(7);
                                        this.p_flg[0] = 150;
                                        this.p_flg[1] = 0;
                                    }
                                }
                            }
                            else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                                if (this.save3[1] != 0) {
                                    this.p_flg[0] = 140;
                                    this.p_flg[1] = this.fusuma2.length - 1;
                                    this.play(12);
                                }
                                else {
                                    for (int n48 = 0; n48 < this.save1.length; ++n48) {
                                        this.save3[n48] = this.save1[n48];
                                    }
                                    for (int n49 = 0; n49 < this.save2.length; ++n49) {
                                        this.save4[n49] = this.save2[n49];
                                    }
                                    for (int n50 = 0; n50 < this.save5.length; ++n50) {
                                        this.save6[n50] = this.save5[n50];
                                    }
                                    this.takara_s();
                                    this.setScene(100);
                                    this.play(1);
                                    this.play(12);
                                }
                            }
                        }
                        else {
                            this.play(10);
                            this.p_flg[16] = 0;
                            while (this.tizu3[this.p_flg[16]] != this.p_flg[2]) {
                                final int[] p_flg25 = this.p_flg;
                                final int n51 = 16;
                                ++p_flg25[n51];
                            }
                            this.p_flg[15] = 0;
                        }
                        this.tizu_s();
                    }
                    else if (this.p_flg[0] == 220) {
                        if (this.c_dai[1] > 0) {
                            final int[] c_dai = this.c_dai;
                            final int n52 = 1;
                            --c_dai[n52];
                            if (this.c_dai[1] == 0) {
                                this.c_dai[0] = 0;
                            }
                        }
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if (this.p_flg[20] > 0) {
                            final int[] p_flg26 = this.p_flg;
                            final int n53 = 20;
                            --p_flg26[n53];
                        }
                        if (this.p_flg[27] == 0) {
                            final int n54 = this.p_flg[2] % 5;
                            final int n55 = this.p_flg[2] / 5;
                            if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                                this.p_flg[2] = (n55 - 1 + 4) % 4 * 5 + n54;
                                if (this.p_flg[2] == 0) {
                                    this.p_flg[2] = 15;
                                }
                                else if (this.p_flg[2] == 19) {
                                    this.p_flg[2] = 14;
                                }
                                this.c_dai[0] = (this.c_dai[1] = 0);
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                                this.p_flg[2] = (n55 + 1) % 4 * 5 + n54;
                                if (this.p_flg[2] == 0) {
                                    this.p_flg[2] = 5;
                                }
                                else if (this.p_flg[2] == 19) {
                                    this.p_flg[2] = 4;
                                }
                                this.c_dai[0] = (this.c_dai[1] = 0);
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                                this.p_flg[2] = n55 * 5 + (n54 + 5 - 1) % 5;
                                if (this.p_flg[2] == 0) {
                                    this.p_flg[2] = 4;
                                }
                                else if (this.p_flg[2] == 19) {
                                    this.p_flg[2] = 18;
                                }
                                this.c_dai[0] = (this.c_dai[1] = 0);
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                                this.p_flg[2] = n55 * 5 + (n54 + 1) % 5;
                                if (this.p_flg[2] == 0) {
                                    this.p_flg[2] = 1;
                                }
                                else if (this.p_flg[2] == 19) {
                                    this.p_flg[2] = 15;
                                }
                                this.c_dai[0] = (this.c_dai[1] = 0);
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                                if (this.p_flg[20] == 0) {
                                    if (this.p_flg[2] >= 1 && this.p_flg[2] <= 9) {
                                        final int n56 = this.p_flg[2] - 1;
                                        if (this.save3[1] >= this.shop2[n56]) {
                                            if (this.save3[n56 + 13] == 10) {
                                                this.c_dai[0] = 3;
                                                this.c_dai[1] = 35;
                                                this.play(15);
                                            }
                                            else if (this.save3[0] >= this.shop1[n56 + 11][this.save3[n56 + 13]]) {
                                                this.p_flg[20] = 4;
                                                this.p_flg[21] = this.p_flg[2];
                                                final int[] save3 = this.save3;
                                                final int n57 = 0;
                                                save3[n57] -= this.shop1[n56 + 11][this.save3[n56 + 13]];
                                                this.p_flg[23] = 0;
                                                final int[] save4 = this.save3;
                                                final int n58 = n56 + 13;
                                                ++save4[n58];
                                                this.play(14);
                                                if (this.save3[22] == 0) {
                                                    int n59 = 0;
                                                    for (int n60 = 0; n60 < 9; ++n60) {
                                                        if (this.save3[n60 + 13] != 0) {
                                                            ++n59;
                                                        }
                                                    }
                                                    if (n59 == 9) {
                                                        this.p_flg[27] = 1;
                                                        this.p_flg[1] = 0;
                                                        this.save3[22] = 1;
                                                    }
                                                }
                                            }
                                            else {
                                                this.c_dai[0] = 7;
                                                this.c_dai[1] = 35;
                                                this.play(15);
                                            }
                                        }
                                        else {
                                            this.c_dai[0] = 8;
                                            this.c_dai[1] = 35;
                                            this.play(15);
                                        }
                                    }
                                    else if (this.p_flg[2] >= 10 && this.p_flg[2] <= 18) {
                                        final int n61 = this.p_flg[2] - 10;
                                        if (this.save3[n61 + 2] == 9) {
                                            this.c_dai[0] = 3;
                                            this.c_dai[1] = 35;
                                            this.play(15);
                                        }
                                        else if (this.save3[0] >= this.shop1[n61][this.save3[n61 + 2]]) {
                                            this.p_flg[20] = 4;
                                            this.p_flg[21] = this.p_flg[2];
                                            final int[] save5 = this.save3;
                                            final int n62 = 0;
                                            save5[n62] -= this.shop1[n61][this.save3[n61 + 2]];
                                            this.p_flg[23] = 0;
                                            final int[] save6 = this.save3;
                                            final int n63 = n61 + 2;
                                            ++save6[n63];
                                            this.play(14);
                                        }
                                        else {
                                            this.c_dai[0] = 7;
                                            this.c_dai[1] = 35;
                                            this.play(15);
                                        }
                                    }
                                }
                            }
                            else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                                this.play(12);
                                this.p_flg[20] = 0;
                                this.p_flg[0] = 230;
                                this.p_flg[1] = this.fusuma2.length - 1;
                            }
                        }
                        else {
                            final int[] p_flg27 = this.p_flg;
                            final int n64 = 1;
                            ++p_flg27[n64];
                            if (this.p_flg[27] == 1) {
                                if (this.p_flg[1] >= 15) {
                                    this.p_flg[27] = 2;
                                    this.p_flg[1] = 0;
                                }
                            }
                            else if (this.p_flg[1] >= 15 && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                                this.p_flg[27] = 0;
                                this.play(11);
                            }
                        }
                    }
                    else if (this.p_flg[0] == 320) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        if (this.p_flg[19] == 0) {
                            if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                                this.play(10);
                                this.p_flg[18] = (this.p_flg[18] - 1 + this.ta1.length) % this.ta1.length;
                            }
                            else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                                this.play(10);
                                this.p_flg[18] = (this.p_flg[18] + 1) % this.ta1.length;
                            }
                            else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                                this.play(10);
                                this.p_flg[19] = 1;
                                this.p_flg[2] = 0;
                            }
                        }
                        else {
                            final int n65 = this.p_flg[2] % 4;
                            int n66 = this.p_flg[2] / 4;
                            final int n67 = this.ta1[this.p_flg[18]];
                            if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                                if (--n66 < 0) {
                                    this.p_flg[19] = 0;
                                }
                                else {
                                    this.p_flg[2] = n66 * 4 + n65;
                                }
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                                if (n67 > (n66 + 1) * 4 + n65) {
                                    ++n66;
                                }
                                this.p_flg[2] = n66 * 4 + n65;
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                                this.p_flg[2] = n66 * 4 + (n65 - 1 + 4) % 4;
                                if (this.p_flg[2] > n67 - 1) {
                                    this.p_flg[2] = n67 - 1;
                                }
                                this.play(10);
                            }
                            else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                                this.p_flg[2] = n66 * 4 + (n65 + 1) % 4;
                                if (this.p_flg[2] > n67 - 1) {
                                    this.p_flg[2] = n66 * 4 + 0;
                                }
                                this.play(10);
                            }
                        }
                        if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.play(12);
                            this.p_flg[0] = 330;
                            this.p_flg[1] = this.fusuma2.length - 1;
                        }
                    }
                    else if (this.p_flg[0] == 140 || this.p_flg[0] == 230 || this.p_flg[0] == 330) {
                        if (this.p_flg[0] == 140) {
                            this.p_flg[7] = (this.p_flg[7] + 1) % 240;
                            this.p_flg[8] = (this.p_flg[8] + 1) % 240;
                        }
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg28 = this.p_flg;
                        final int n68 = 1;
                        --p_flg28[n68];
                        if (this.p_flg[1] < 0) {
                            if (this.p_flg[0] == 140) {
                                this.p_flg[0] = 115;
                            }
                            else if (this.p_flg[0] == 230) {
                                this.p_flg[0] = 240;
                                this.p_flg[4] = 1;
                                this.p_flg[5] = 0;
                            }
                            else {
                                this.p_flg[0] = 340;
                                this.p_flg[4] = 1;
                                this.p_flg[5] = 0;
                            }
                            this.p_flg[1] = this.fusuma1.length - 1;
                        }
                    }
                    else if (this.p_flg[0] == 150) {
                        this.p_flg[3] = (this.p_flg[3] + 1) % 2;
                        final int[] p_flg29 = this.p_flg;
                        final int n69 = 1;
                        ++p_flg29[n69];
                        if (this.p_flg[1] >= this.men1.length) {
                            this.p_flg[0] = 151;
                            this.p_flg[1] = 0;
                        }
                    }
                    else if (this.p_flg[0] == 151) {
                        final int[] p_flg30 = this.p_flg;
                        final int n70 = 1;
                        ++p_flg30[n70];
                        if (this.p_flg[1] >= this.men2.length) {
                            this.p_flg[0] = 152;
                            this.p_flg[1] = 0;
                            this.p_flg[4] = 3;
                            this.p_flg[5] = 0;
                        }
                        else {
                            this.p_flg[7] = (this.p_flg[7] + this.men2[this.p_flg[1]]) % 240;
                            this.p_flg[8] = (this.p_flg[8] + this.men2[this.p_flg[1]]) % 240;
                            final int[] p_flg31 = this.p_flg;
                            final int n71 = 9;
                            p_flg31[n71] += this.men2[this.p_flg[1]];
                            final int[] p_flg32 = this.p_flg;
                            final int n72 = 10;
                            p_flg32[n72] += this.men2[this.p_flg[1]];
                        }
                    }
                    else if (this.p_flg[0] == 152) {
                        final int[] p_flg33 = this.p_flg;
                        final int n73 = 1;
                        ++p_flg33[n73];
                        if (this.p_flg[1] == 15) {
                            for (int n74 = 0; n74 < MyCanvas.img.length; ++n74) {
                                if (MyCanvas.bunrui[n74] == 1 || MyCanvas.bunrui[n74] == 3) {
                                    this.g_free(n74);
                                }
                            }
                            for (int n75 = 0; n75 < MyCanvas.img.length; ++n75) {
                                if (MyCanvas.bunrui[n75] == 2) {
                                    this.g_load(n75);
                                }
                            }
                            this.syoki_iti = this.p_flg[2];
                            final int n76 = this.p_flg[2];
                            for (int n77 = 0; n77 < this.p_flg.length; ++n77) {
                                this.p_flg[n77] = 0;
                            }
                            this.p_flg[0] = n76;
                            this.st_s();
                            this.p_flg[14] = 3;
                            this.p_flg[15] = 0;
                            this.p_flg[16] = 0;
                            this.setScene(400);
                            MyCanvas.slvar[0] = 0L;
                        }
                    }
                    if (this.p_flg[0] >= 100 && this.p_flg[22] != this.save3[0]) {
                        if (this.p_flg[23] == 0) {
                            this.p_flg[23] = (this.save3[0] - this.p_flg[22]) / 9;
                            if (this.p_flg[23] == 0) {
                                this.p_flg[22] = this.save3[0];
                            }
                        }
                        final int[] p_flg34 = this.p_flg;
                        final int n78 = 22;
                        p_flg34[n78] += this.p_flg[23];
                        if (this.p_flg[22] <= this.save3[0]) {
                            this.p_flg[22] = this.save3[0];
                            this.p_flg[23] = 0;
                        }
                    }
                    if (this.p_flg[4] == 1) {
                        final int[] p_flg35 = this.p_flg;
                        final int n79 = 5;
                        ++p_flg35[n79];
                        if (this.p_flg[5] >= this.n_tbl1.length) {
                            this.p_flg[4] = 2;
                            this.p_flg[5] = 0;
                            this.p_flg[6] = 0;
                            break;
                        }
                        break;
                    }
                    else if (this.p_flg[4] == 2) {
                        this.p_flg[5] = (this.p_flg[5] + 1) % this.n_tbl2.length;
                        final int[] p_flg36 = this.p_flg;
                        final int n80 = 6;
                        --p_flg36[n80];
                        if (this.p_flg[6] <= 0) {
                            this.p_flg[6] = 15 + this.random(60);
                            break;
                        }
                        break;
                    }
                    else {
                        if (this.p_flg[4] == 3) {
                            final int[] p_flg37 = this.p_flg;
                            final int n81 = 5;
                            ++p_flg37[n81];
                            this.p_flg[6] = 0;
                            break;
                        }
                        if (this.p_flg[4] != 4) {
                            break;
                        }
                        final int[] p_flg38 = this.p_flg;
                        final int n82 = 5;
                        --p_flg38[n82];
                        if (this.p_flg[5] <= 0) {
                            this.p_flg[4] = 0;
                            break;
                        }
                        break;
                    }
                }
                case 400: {
                    final int[] kiri = this.kiri;
                    final int n83 = 0;
                    ++kiri[n83];
                    if (this.kiri[0] >= this.kiri_tbl1.length) {
                        this.setScene(401);
                        break;
                    }
                    break;
                }
                case 401: {
                    final int[] kiri2 = this.kiri;
                    final int n84 = 0;
                    ++kiri2[n84];
                    if (this.kiri[0] >= this.kiri_tbl2.length) {
                        this.setScene(300);
                        break;
                    }
                    break;
                }
                case 402: {
                    final int[] kiri3 = this.kiri;
                    final int n85 = 0;
                    ++kiri3[n85];
                    if (this.kiri[0] >= this.kiri_tbl1.length) {
                        if (this.p_flg[21] == 0) {
                            for (int n86 = 0; n86 < MyCanvas.img.length; ++n86) {
                                if (MyCanvas.bunrui[n86] == 2 || MyCanvas.bunrui[n86] == 3) {
                                    this.g_free(n86);
                                }
                            }
                            for (int n87 = 0; n87 < MyCanvas.img.length; ++n87) {
                                if (MyCanvas.bunrui[n87] == 1) {
                                    this.g_load(n87);
                                }
                            }
                            MyCanvas.slvar[0] = 0L;
                            final int n88 = this.p_flg[0];
                            this.setScene(100);
                            if (n88 == 48) {
                                this.p_flg[0] = 21;
                                this.play(1);
                            }
                            else if (this.save3[1] != 0) {
                                this.p_flg[0] = 100;
                                this.p_flg[4] = 1;
                                this.p_flg[22] = this.save3[0];
                                this.play(2);
                            }
                            else {
                                this.play(1);
                            }
                        }
                        else {
                            for (int n89 = 0; n89 < MyCanvas.img.length; ++n89) {
                                if (MyCanvas.bunrui[n89] == 2 || MyCanvas.bunrui[n89] == 3) {
                                    this.g_free(n89);
                                }
                            }
                            this.g_load(53);
                            this.g_load(255);
                            this.g_load(256);
                            MyCanvas.slvar[0] = 0L;
                            for (int n90 = 0; n90 < this.p_flg.length; ++n90) {
                                this.p_flg[n90] = 0;
                            }
                            this.setScene(501);
                            this.save0[0] = 1;
                        }
                        this.save();
                        break;
                    }
                    break;
                }
                case 300: {
                    final int[] p_flg39 = this.p_flg;
                    final int n91 = 1;
                    ++p_flg39[n91];
                    if (this.p_flg[12] != 0) {
                        if (this.p_flg[12] == 1) {
                            final int n92 = this.dat[0] - 2400 - this.p_flg[5];
                            if (n92 > 1200) {
                                final int[] p_flg40 = this.p_flg;
                                final int n93 = 5;
                                p_flg40[n93] += 650;
                            }
                            else if (n92 / 2 <= 10) {
                                this.p_flg[5] = this.dat[0] - 2400;
                                this.p_flg[12] = 0;
                            }
                            else {
                                final int[] p_flg41 = this.p_flg;
                                final int n94 = 5;
                                p_flg41[n94] += n92 / 2;
                            }
                        }
                        else if (this.p_flg[12] == 2) {
                            final int n95 = this.p_flg[5];
                            if (n95 > 1200) {
                                final int[] p_flg42 = this.p_flg;
                                final int n96 = 5;
                                p_flg42[n96] -= 650;
                            }
                            else if (n95 / 2 <= 10) {
                                this.p_flg[5] = 0;
                                this.p_flg[12] = 0;
                            }
                            else {
                                final int[] p_flg43 = this.p_flg;
                                final int n97 = 5;
                                p_flg43[n97] -= n95 / 2;
                            }
                        }
                        else if (this.p_flg[12] == 3) {
                            int n98 = 0;
                            for (int n99 = 0; n99 < this.uni[1].length; ++n99) {
                                if (this.uni[1][n99][0] != 0) {
                                    if (this.uni[1][n99][1] != 4) {
                                        if (this.uni[1][n99][3] > n98) {
                                            n98 = this.uni[1][n99][3];
                                        }
                                    }
                                }
                            }
                            if (n98 < 1200) {
                                n98 = 1200;
                            }
                            else if (n98 > this.dat[0] - 1200) {
                                n98 = this.dat[0] - 1200;
                            }
                            if (n98 >= this.p_flg[5] + 1200) {
                                final int n100 = n98 - (this.p_flg[5] + 1200);
                                if (n100 > 1200) {
                                    final int[] p_flg44 = this.p_flg;
                                    final int n101 = 5;
                                    p_flg44[n101] += 300;
                                }
                                else {
                                    final int[] p_flg45 = this.p_flg;
                                    final int n102 = 5;
                                    p_flg45[n102] += n100 / 4;
                                }
                            }
                            else {
                                final int n103 = this.p_flg[5] + 1200 - n98;
                                if (n103 > 1200) {
                                    final int[] p_flg46 = this.p_flg;
                                    final int n104 = 5;
                                    p_flg46[n104] -= 300;
                                }
                                else {
                                    final int[] p_flg47 = this.p_flg;
                                    final int n105 = 5;
                                    p_flg47[n105] -= n103 / 4;
                                }
                            }
                        }
                    }
                    if (this.p_flg[14] == 1) {
                        if (this.p_flg[15] != 0) {
                            if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x10010) != 0x0) {
                                final int[] p_flg48 = this.p_flg;
                                final int n106 = 5;
                                p_flg48[n106] -= 100;
                                if (this.p_flg[5] < 0) {
                                    this.p_flg[5] = 0;
                                }
                            }
                            else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x40040) != 0x0) {
                                final int[] p_flg49 = this.p_flg;
                                final int n107 = 5;
                                p_flg49[n107] += 100;
                                if (this.p_flg[5] > this.dat[0] - 2400) {
                                    this.p_flg[5] = this.dat[0] - 2400;
                                }
                            }
                        }
                        final int[] p_flg50 = this.p_flg;
                        final int n108 = 16;
                        ++p_flg50[n108];
                        if (this.p_flg[15] == 0) {
                            if (this.p_flg[12] == 0 && this.p_flg[16] >= 10) {
                                this.p_flg[15] = 1;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] >= 1 && this.p_flg[15] <= 2) {
                            if (this.p_flg[16] >= this.s_tbl1.length) {
                                final int[] p_flg51 = this.p_flg;
                                final int n109 = 15;
                                ++p_flg51[n109];
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 3) {
                            if (this.p_flg[16] >= 15) {
                                this.p_flg[18] = 0;
                                this.p_flg[19] = -1;
                                if (35 + this.ta7[10] * this.p_flg3[10] / 100 > this.random(100)) {
                                    int n110 = 0;
                                    if (this.save0[0] != 0) {
                                        ++n110;
                                    }
                                    if (this.save6[this.p_flg[20]] != 0) {
                                        ++n110;
                                    }
                                    final int random = this.random(100);
                                    if (n110 != 2) {
                                        if (random < 45) {
                                            this.p_flg[18] = 1;
                                        }
                                        else if (random < 75) {
                                            this.p_flg[18] = 2;
                                        }
                                        else {
                                            this.p_flg[18] = 3;
                                        }
                                    }
                                    else if (random < 30) {
                                        this.p_flg[18] = 1;
                                    }
                                    else if (random < 60) {
                                        this.p_flg[18] = 2;
                                    }
                                    else {
                                        this.p_flg[18] = 3;
                                    }
                                    if (this.save6[this.p_flg[20]] < this.p_flg[18]) {
                                        this.save6[this.p_flg[20]] = this.p_flg[18];
                                    }
                                    int n111 = -1;
                                    for (int n112 = 0; n112 < this.ta1.length; ++n112) {
                                        for (int n113 = 0; n113 < this.ta1[n112]; ++n113) {
                                            if (this.ta2[n112][n113] == this.p_flg[20]) {
                                                n111 = n112;
                                                break;
                                            }
                                        }
                                        if (n111 != -1) {
                                            break;
                                        }
                                    }
                                    if (n111 >= 0) {
                                        if (this.p_flg3[n111] == 0) {
                                            this.takara_s();
                                            if (this.p_flg3[n111] != 0) {
                                                this.p_flg[19] = n111;
                                            }
                                        }
                                        else {
                                            this.takara_s();
                                        }
                                    }
                                    this.p_flg[15] = 4;
                                    this.p_flg[16] = 0;
                                    this.play(29);
                                }
                                else {
                                    this.p_flg[15] = 6;
                                    this.p_flg[16] = 0;
                                }
                            }
                        }
                        else if (this.p_flg[15] == 4) {
                            if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                                if (this.p_flg[19] != -1) {
                                    this.p_flg[15] = 5;
                                    this.p_flg[16] = 0;
                                    this.play(29);
                                }
                                else {
                                    this.setScene(402);
                                    this.play(11);
                                }
                            }
                        }
                        else if ((this.p_flg[15] == 5 || this.p_flg[15] == 6) && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.setScene(402);
                            this.play(11);
                            break;
                        }
                    }
                    else if (this.p_flg[14] == 2) {
                        final int[] p_flg52 = this.p_flg;
                        final int n114 = 16;
                        ++p_flg52[n114];
                        if (this.p_flg[15] == 0) {
                            if (this.p_flg[12] == 0 && this.p_flg[16] >= 10) {
                                this.p_flg[15] = 1;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 1) {
                            if (this.p_flg[16] >= this.s_tbl3.length) {
                                this.p_flg[15] = 2;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 2) {
                            if (this.p_flg[16] >= 40) {
                                this.p_flg[15] = 3;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 3 && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.setScene(402);
                            this.play(11);
                            break;
                        }
                    }
                    else if (this.p_flg[14] == 3) {
                        if (this.save3[1] == 0) {
                            if (this.p_flg[1] == 1) {
                                this.play(this.tizu5[this.p_flg[0] * 3]);
                            }
                            if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                                this.play(11);
                                this.p_flg[14] = 0;
                            }
                        }
                        else {
                            this.p_flg[14] = 0;
                            this.play(this.tizu5[this.p_flg[0] * 3]);
                        }
                    }
                    else if (this.p_flg[14] == 4) {
                        if (this.p_flg[15] != 0) {
                            if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x10010) != 0x0) {
                                final int[] p_flg53 = this.p_flg;
                                final int n115 = 5;
                                p_flg53[n115] -= 100;
                                if (this.p_flg[5] < 0) {
                                    this.p_flg[5] = 0;
                                }
                            }
                            else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x40040) != 0x0) {
                                final int[] p_flg54 = this.p_flg;
                                final int n116 = 5;
                                p_flg54[n116] += 100;
                                if (this.p_flg[5] > this.dat[0] - 2400) {
                                    this.p_flg[5] = this.dat[0] - 2400;
                                }
                            }
                        }
                        final int[] p_flg55 = this.p_flg;
                        final int n117 = 16;
                        ++p_flg55[n117];
                        if (this.p_flg[15] == 0) {
                            if (this.p_flg[12] == 0 && this.p_flg[16] >= 10) {
                                this.p_flg[15] = 1;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] >= 1 && this.p_flg[15] <= 2) {
                            if (this.p_flg[16] >= this.s_tbl1.length) {
                                final int[] p_flg56 = this.p_flg;
                                final int n118 = 15;
                                ++p_flg56[n118];
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 3 && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.setScene(402);
                            this.play(11);
                            break;
                        }
                    }
                    else if (this.p_flg[14] == 5) {
                        final int[] p_flg57 = this.p_flg;
                        final int n119 = 16;
                        ++p_flg57[n119];
                        if (this.p_flg[15] == 0) {
                            if (this.p_flg[12] == 0 && this.p_flg[16] >= 10) {
                                this.p_flg[15] = 1;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 1) {
                            if (this.p_flg[16] >= this.s_tbl3.length) {
                                this.p_flg[15] = 2;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 2) {
                            if (this.p_flg[16] >= 40) {
                                this.p_flg[15] = 3;
                                this.p_flg[16] = 0;
                            }
                        }
                        else if (this.p_flg[15] == 3 && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.setScene(402);
                            this.play(11);
                            break;
                        }
                    }
                    else if (this.p_flg[2] == 0) {
                        if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.setScene(350);
                            this.play(11);
                            break;
                        }
                        if ((MyCanvas.sivar[13] & 0x400000) != 0x0) {
                            this.sach(0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x1) != 0x0) {
                            this.sach(1);
                        }
                        else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x10410) != 0x0) {
                            final int[] p_flg58 = this.p_flg;
                            final int n120 = 5;
                            p_flg58[n120] -= 100;
                            if (this.p_flg[5] < 0) {
                                this.p_flg[5] = 0;
                            }
                            this.p_flg[12] = 0;
                        }
                        else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x40840) != 0x0) {
                            final int[] p_flg59 = this.p_flg;
                            final int n121 = 5;
                            p_flg59[n121] += 100;
                            if (this.p_flg[5] > this.dat[0] - 2400) {
                                this.p_flg[5] = this.dat[0] - 2400;
                            }
                            this.p_flg[12] = 0;
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.play(16);
                            this.p_flg[2] = 1;
                            this.c_dai[0] = (this.c_dai[1] = 0);
                            this.setSoftLabel(0, MyCanvas.soft_label[0] = "\u623b\u308b");
                        }
                    }
                    else {
                        this.p_flg[4] = (this.p_flg[4] + 1) % 2;
                        if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                            this.play(18);
                            final int n122 = this.p_flg[3] / 5;
                            int n123 = (this.p_flg[3] % 5 + 5 - 1) % 5;
                            if (n122 == 0 && n123 >= 4) {
                                n123 = 1;
                            }
                            this.p_flg[3] = n122 * 5 + n123;
                            this.c_dai[0] = (this.c_dai[1] = 0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                            this.play(18);
                            final int n124 = this.p_flg[3] / 5;
                            int n125 = (this.p_flg[3] % 5 + 1) % 5;
                            if (n124 == 0 && n125 >= 2) {
                                n125 = 0;
                            }
                            this.p_flg[3] = n124 * 5 + n125;
                            this.c_dai[0] = (this.c_dai[1] = 0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
                            this.play(18);
                            this.p_flg[3] = (this.p_flg[3] / 5 + 3 - 1) % 3 * 5 + this.p_flg[3] % 5;
                            if (this.p_flg[3] >= 2 && this.p_flg[3] <= 4) {
                                final int[] p_flg60 = this.p_flg;
                                final int n126 = 3;
                                p_flg60[n126] += 10;
                            }
                            this.c_dai[0] = (this.c_dai[1] = 0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
                            this.play(18);
                            this.p_flg[3] = (this.p_flg[3] / 5 + 1) % 3 * 5 + this.p_flg[3] % 5;
                            if (this.p_flg[3] >= 2 && this.p_flg[3] <= 4) {
                                final int[] p_flg61 = this.p_flg;
                                final int n127 = 3;
                                p_flg61[n127] += 5;
                            }
                            this.c_dai[0] = (this.c_dai[1] = 0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x200000) != 0x0) {
                            this.play(17);
                            this.setSoftLabel(this.p_flg[2] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                            this.c_dai[0] = (this.c_dai[1] = 0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x400000) != 0x0) {
                            this.sach(0);
                        }
                        else if ((MyCanvas.sivar[13] & 0x1) != 0x0) {
                            this.sach(1);
                        }
                        else if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.c_dai[0] = (this.c_dai[1] = 0);
                            if (this.p_flg[3] == 0) {
                                if (this.uni[0][0][12] == 0) {
                                    this.play(19);
                                    if (MyCanvas.snd_val[0] > 1) {
                                        MyCanvas.snd_opt[3] = 1;
                                        this.play(25);
                                    }
                                    this.uni[0][0][12] = this.uni[0][0][11];
                                    this.uni[0][0][9] = 1;
                                    this.uni[0][0][10] = 0;
                                    final int[] array7 = this.uni[0][0];
                                    final int n128 = 13;
                                    ++array7[n128];
                                    this.setSoftLabel(this.p_flg[2] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                                }
                                else {
                                    this.play(15);
                                    this.c_dai[0] = 2;
                                    this.c_dai[1] = 35;
                                }
                            }
                            else if (this.p_flg[3] == 1) {
                                if (this.p_flg2[1][0] != 7) {
                                    if (this.p_flg[10] >= this.nyan10[this.p_flg[11]][this.p_flg2[1][0]]) {
                                        this.play(19);
                                        final int[] p_flg62 = this.p_flg;
                                        final int n129 = 10;
                                        p_flg62[n129] -= this.nyan10[this.p_flg[11]][this.p_flg2[1][0]];
                                        final int[] array8 = this.p_flg2[1];
                                        final int n130 = 0;
                                        ++array8[n130];
                                        this.p_flg2[1][1] = 0;
                                        this.p_flg2[1][2] = 0;
                                        this.p_flg[9] = this.p_flg[7] * (10 + this.p_flg2[1][0] * 5) / 10;
                                        final int[] p_flg63 = this.p_flg;
                                        final int n131 = 9;
                                        p_flg63[n131] += this.ta7[1] * this.p_flg3[1] / 100;
                                        this.p_flg[8] = this.p_flg[6] * (10 + this.p_flg2[1][0]) / 10;
                                        final int[] p_flg64 = this.p_flg;
                                        final int n132 = 8;
                                        p_flg64[n132] += this.ta7[0] * this.p_flg3[0] / 100;
                                        this.setSoftLabel(this.p_flg[2] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                                        this.p_flg[25] = 7;
                                    }
                                    else {
                                        this.play(15);
                                        this.c_dai[0] = 1;
                                        this.c_dai[1] = 35;
                                    }
                                }
                                else {
                                    this.play(15);
                                    this.c_dai[0] = 3;
                                    this.c_dai[1] = 35;
                                }
                            }
                            else if (this.p_flg[3] == 5) {
                                this.play(17);
                                this.setSoftLabel(this.p_flg[2] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                            }
                            else {
                                final int n133 = this.p_flg[3] - 6 + 2;
                                if (this.p_flg2[n133][0] == 0) {
                                    this.c_dai[0] = 4;
                                    this.c_dai[1] = 35;
                                    this.play(15);
                                }
                                else if (this.p_flg2[n133][1] != 0) {
                                    this.c_dai[0] = 5;
                                    this.c_dai[1] = 35;
                                    this.play(15);
                                }
                                else if (this.p_flg[10] < this.uni_dat1[n133][this.p_flg2[n133][0] - 1][6]) {
                                    this.c_dai[0] = 1;
                                    this.c_dai[1] = 35;
                                    this.play(15);
                                }
                                else if (this.uni_s(0, n133, this.p_flg2[n133][0] - 1, 0, 9) >= 0) {
                                    final int[] p_flg65 = this.p_flg;
                                    final int n134 = 10;
                                    p_flg65[n134] -= this.uni_dat1[n133][this.p_flg2[n133][0] - 1][6];
                                    this.p_flg2[n133][1] = this.uni_dat1[n133][this.p_flg2[n133][0] - 1][7];
                                    final int[] array9 = this.p_flg2[n133];
                                    final int n135 = 1;
                                    array9[n135] -= this.nyan12[this.save3[8]];
                                    final int[] array10 = this.p_flg2[n133];
                                    final int n136 = 1;
                                    array10[n136] -= this.ta7[2] * this.p_flg3[2] / 100;
                                    if (this.p_flg2[n133][1] <= 1) {
                                        this.p_flg2[n133][1] = 1;
                                    }
                                    this.setSoftLabel(this.p_flg[2] = 0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
                                    this.play(19);
                                }
                                else {
                                    this.play(15);
                                    this.c_dai[0] = 6;
                                    this.c_dai[1] = 35;
                                }
                            }
                        }
                        else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x400) != 0x0) {
                            final int[] p_flg66 = this.p_flg;
                            final int n137 = 5;
                            p_flg66[n137] -= 100;
                            if (this.p_flg[5] < 0) {
                                this.p_flg[5] = 0;
                            }
                            this.p_flg[12] = 0;
                        }
                        else if (((MyCanvas.sivar[13] | MyCanvas.sivar[15]) & 0x800) != 0x0) {
                            final int[] p_flg67 = this.p_flg;
                            final int n138 = 5;
                            p_flg67[n138] += 100;
                            if (this.p_flg[5] > this.dat[0] - 2400) {
                                this.p_flg[5] = this.dat[0] - 2400;
                            }
                            this.p_flg[12] = 0;
                        }
                    }
                    if (this.p_flg[14] == 0) {
                        --this.t_flg;
                        for (int n139 = 0; n139 < this.dat2.length; ++n139) {
                            if (this.dat2[n139][0] != 0) {
                                if (this.uni[1][0][8] <= this.uni[1][0][7] * this.dat2[n139][5] / 100) {
                                    if (this.dat2[n139][1] == 0 || this.t_flg2[n139][1] < this.dat2[n139][1]) {
                                        final int[] array11 = this.t_flg2[n139];
                                        final int n140 = 0;
                                        --array11[n140];
                                    }
                                }
                                else {
                                    this.t_flg2[n139][0] = 1;
                                }
                            }
                        }
                        if (this.t_flg <= 0) {
                            int n141 = 0;
                            for (int n142 = 1; n142 < this.uni[1].length; ++n142) {
                                if (this.uni[1][n142][0] != 0) {
                                    ++n141;
                                }
                            }
                            if (n141 < this.dat[5]) {
                                int n143 = this.dat2.length - 1;
                                while (n143 >= 0) {
                                    if (this.dat2[n143][0] != 0 && this.t_flg2[n143][0] <= 0) {
                                        if (this.uni_s(1, this.dat2[n143][0], 0, this.dat2[n143][6], this.dat2[n143][7]) < 0) {
                                            break;
                                        }
                                        this.t_flg = this.random(this.dat[3] - this.dat[2] + 1) + this.dat[2];
                                        this.t_flg2[n143][0] = this.random(this.dat2[n143][4] - this.dat2[n143][3] + 1) + this.dat2[n143][3];
                                        final int[] array12 = this.t_flg2[n143];
                                        final int n144 = 1;
                                        ++array12[n144];
                                        if (this.save0[4 + this.dat2[n143][0] - 2] == 0) {
                                            this.save0[4 + this.dat2[n143][0] - 2] = 1;
                                            break;
                                        }
                                        break;
                                    }
                                    else {
                                        --n143;
                                    }
                                }
                            }
                        }
                    }
                    for (int n145 = 0; n145 < this.uni[0].length; ++n145) {
                        if (this.uni[0][n145][0] != 0) {
                            this.uni[0][n145][19] = 0;
                            if (n145 == 0) {
                                if (this.uni[0][0][9] == 1) {
                                    final int[] array13 = this.uni[0][0];
                                    final int n146 = 10;
                                    ++array13[n146];
                                    if (this.uni[0][0][10] > 8) {
                                        this.uni[0][0][9] = 2;
                                        this.uni[0][0][10] = 0;
                                        MyCanvas.snd_opt[1] = 1;
                                        MyCanvas.snd_opt[2] = 25;
                                        this.play(-2);
                                    }
                                }
                                else if (this.uni[0][0][9] == 2) {
                                    final int[] array14 = this.uni[0][0];
                                    final int n147 = 10;
                                    ++array14[n147];
                                    if (this.uni[0][0][10] % 2 == 0) {
                                        int n148 = 0;
                                        while (n148 < this.ef2.length) {
                                            if (this.ef2[n148][0] == 0) {
                                                if (this.p_flg[14] == 0 && MyCanvas.snd_val[0] > 1) {
                                                    MyCanvas.snd_opt[3] = 1;
                                                    this.play(26);
                                                }
                                                this.ef2[n148][0] = this.nyan5.length;
                                                this.ef2[n148][1] = this.uni[0][0][3] + 90 - this.uni[0][0][10] / 2 * this.nyan3 * 10;
                                                this.ef2[n148][2] = this.uni[0][0][13];
                                                if (this.uni[0][0][10] / 2 >= this.uni[0][0][6]) {
                                                    this.uni[0][0][9] = 0;
                                                    this.uni[0][0][10] = 0;
                                                    break;
                                                }
                                                break;
                                            }
                                            else {
                                                ++n148;
                                            }
                                        }
                                    }
                                }
                                if (this.uni[0][0][8] <= 0) {
                                    this.uni[0][0][1] = 2;
                                    final int n149 = this.p_flg[1] % 5;
                                    this.ef1[0][50 + n149][0] = 6;
                                    this.ef1[0][50 + n149][1] = this.uni[0][0][3] - 225 + this.random(60) * 10;
                                    this.ef1[0][50 + n149][2] = 1560 - this.random(120) * 10;
                                }
                                else if (this.uni[0][0][1] == 1) {
                                    final int[] array15 = this.uni[0][0];
                                    final int n150 = 2;
                                    --array15[n150];
                                    if (this.uni[0][0][2] <= 0) {
                                        this.uni[0][0][1] = 0;
                                        this.uni[0][0][2] = 0;
                                    }
                                }
                                if (this.uni[0][0][5] > 0) {
                                    final int[] array16 = this.uni[0][0];
                                    final int n151 = 5;
                                    --array16[n151];
                                }
                            }
                            else {
                                if (this.uni[0][n145][18] > 0) {
                                    final int[] array17 = this.uni[0][n145];
                                    final int n152 = 18;
                                    --array17[n152];
                                }
                                this.uni[0][n145][23] = 0;
                                if (this.uni[0][n145][1] == 0) {
                                    int n153 = 0;
                                    if (n153 == 0) {
                                        for (int n154 = 0; n154 < this.uni[1].length; ++n154) {
                                            if (this.syatei(0, n145, n154) == 1) {
                                                n153 = 1;
                                                break;
                                            }
                                        }
                                    }
                                    if (n153 == 0) {
                                        final int[] array18 = this.uni[0][n145];
                                        final int n155 = 3;
                                        array18[n155] -= this.uni[0][n145][10];
                                        if (this.uni[0][n145][3] < 800) {
                                            this.uni[0][n145][3] = 800;
                                        }
                                        this.uni_a1(n145);
                                    }
                                }
                                else if (this.uni[0][n145][1] == 3) {
                                    this.uni_a1(n145);
                                    if (this.uni[0][n145][2] == 0) {
                                        this.uni[0][n145][1] = 0;
                                        if (this.uni[0][n145][8] == 0) {
                                            if (MyCanvas.snd_val[0] > 2) {
                                                MyCanvas.snd_opt[3] = 2;
                                                this.play(24);
                                            }
                                            this.uni[0][n145][1] = 4;
                                            this.uni[0][n145][2] = 0;
                                            this.uni[0][n145][10] = (this.random(6) + 5) * 10;
                                        }
                                    }
                                    else {
                                        final int[] array19 = this.uni[0][n145];
                                        final int n156 = 3;
                                        array19[n156] += 30;
                                        final int[] array20 = this.uni[0][n145];
                                        final int n157 = 4;
                                        array20[n157] += this.bak_tbl1[this.uni[0][n145][2]];
                                    }
                                }
                                else if (this.uni[0][n145][1] == 4) {
                                    this.uni_a1(n145);
                                    final int[] array21 = this.uni[0][n145];
                                    final int n158 = 4;
                                    array21[n158] -= this.uni[0][n145][10];
                                    if (this.uni[0][n145][4] <= -200) {
                                        this.uni[0][n145][0] = 0;
                                    }
                                }
                                else if (this.uni[0][n145][1] == 5) {
                                    this.uni_a1(n145);
                                    if (this.uni[0][n145][2] == 0) {
                                        this.uni[0][n145][1] = 0;
                                    }
                                    else {
                                        final int[] array22 = this.uni[0][n145];
                                        final int n159 = 3;
                                        array22[n159] += 10;
                                        final int[] array23 = this.uni[0][n145];
                                        final int n160 = 4;
                                        array23[n160] += this.bak_tbl2[this.uni[0][n145][2]];
                                    }
                                }
                            }
                        }
                    }
                    for (int n161 = 0; n161 < this.uni[1].length; ++n161) {
                        if (this.uni[1][n161][0] != 0) {
                            this.uni[1][n161][19] = 0;
                            if (n161 == 0) {
                                if (this.uni[1][0][8] <= 0) {
                                    this.uni[1][0][1] = 2;
                                    final int n162 = this.p_flg[1] % 5;
                                    this.ef1[1][50 - n162][0] = 6;
                                    this.ef1[1][50 - n162][1] = this.uni[1][0][3] - 225 - this.random(60) * 10;
                                    this.ef1[1][50 - n162][2] = 1560 - this.random(120) * 10;
                                }
                                else if (this.uni[1][0][1] == 1) {
                                    final int[] array24 = this.uni[1][0];
                                    final int n163 = 2;
                                    --array24[n163];
                                    if (this.uni[1][0][2] <= 0) {
                                        this.uni[1][0][1] = 0;
                                        this.uni[1][0][2] = 0;
                                    }
                                }
                                if (this.uni[1][0][5] > 0) {
                                    final int[] array25 = this.uni[1][0];
                                    final int n164 = 5;
                                    --array25[n164];
                                }
                            }
                            else {
                                if (this.uni[1][n161][18] > 0) {
                                    final int[] array26 = this.uni[1][n161];
                                    final int n165 = 18;
                                    --array26[n165];
                                }
                                this.uni[1][n161][23] = 0;
                                if (this.uni[1][n161][1] == 0) {
                                    int n166 = 0;
                                    if (n166 == 0) {
                                        for (int n167 = 0; n167 < this.uni[1].length; ++n167) {
                                            if (this.syatei(1, n161, n167) == 1) {
                                                n166 = 1;
                                                break;
                                            }
                                        }
                                    }
                                    if (n166 == 0) {
                                        final int[] array27 = this.uni[1][n161];
                                        final int n168 = 3;
                                        array27[n168] += this.uni[1][n161][10];
                                        this.uni_a2(n161);
                                    }
                                }
                                else if (this.uni[1][n161][1] == 3) {
                                    this.uni_a2(n161);
                                    if (this.uni[1][n161][2] == 0) {
                                        this.uni[1][n161][1] = 0;
                                        if (this.uni[1][n161][8] == 0) {
                                            if (MyCanvas.snd_val[0] > 2) {
                                                MyCanvas.snd_opt[3] = 2;
                                                this.play(23);
                                            }
                                            this.uni[1][n161][1] = 4;
                                            this.uni[1][n161][2] = 0;
                                            this.uni[1][n161][10] = (this.random(6) + 5) * 10;
                                            final int n169 = this.uni_dat2[this.uni[1][n161][0]][6];
                                            final int n170 = this.nyan11[this.save3[9]] + this.ta7[5] * this.p_flg3[5] / 100;
                                            final int[] p_flg68 = this.p_flg;
                                            final int n171 = 10;
                                            p_flg68[n171] += n169 * n170 / 100;
                                            if (this.p_flg[10] > this.p_flg[9]) {
                                                this.p_flg[10] = this.p_flg[9];
                                            }
                                            if (this.p_flg[0] == 48) {
                                                if (this.uni[1][n161][0] == 12) {
                                                    final int[] p_flg69 = this.p_flg;
                                                    final int n172 = 22;
                                                    p_flg69[n172] += 3000;
                                                }
                                                else if (this.uni[1][n161][0] == 18) {
                                                    final int[] p_flg70 = this.p_flg;
                                                    final int n173 = 22;
                                                    p_flg70[n173] += 10000;
                                                }
                                                else if (this.uni[1][n161][0] == 19) {
                                                    final int[] p_flg71 = this.p_flg;
                                                    final int n174 = 22;
                                                    p_flg71[n174] += 20000;
                                                }
                                                else if (this.uni[1][n161][0] == 20) {
                                                    final int[] p_flg72 = this.p_flg;
                                                    final int n175 = 22;
                                                    p_flg72[n175] += 20000;
                                                }
                                                else if (this.uni[1][n161][0] == 24) {
                                                    final int[] p_flg73 = this.p_flg;
                                                    final int n176 = 22;
                                                    p_flg73[n176] += 10000;
                                                }
                                                else {
                                                    final int[] p_flg74 = this.p_flg;
                                                    final int n177 = 26;
                                                    p_flg74[n177] += 7;
                                                    if (this.p_flg[26] > 10000) {
                                                        this.p_flg[26] = 10000;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        final int[] array28 = this.uni[1][n161];
                                        final int n178 = 3;
                                        array28[n178] -= 30;
                                        final int[] array29 = this.uni[1][n161];
                                        final int n179 = 4;
                                        array29[n179] += this.bak_tbl1[this.uni[1][n161][2]];
                                        if (this.uni[0][n161][3] > this.dat[0] - 800) {
                                            this.uni[0][n161][3] = this.dat[0] - 800;
                                        }
                                    }
                                }
                                else if (this.uni[1][n161][1] == 4) {
                                    this.uni_a2(n161);
                                    final int[] array30 = this.uni[1][n161];
                                    final int n180 = 4;
                                    array30[n180] -= this.uni[1][n161][10];
                                    if (this.uni[1][n161][4] <= -200) {
                                        this.uni[1][n161][0] = 0;
                                    }
                                }
                                else if (this.uni[1][n161][1] == 5) {
                                    this.uni_a2(n161);
                                    if (this.uni[1][n161][2] == 0) {
                                        this.uni[1][n161][1] = 0;
                                    }
                                    else {
                                        final int[] array31 = this.uni[1][n161];
                                        final int n181 = 3;
                                        array31[n181] -= 10;
                                        final int[] array32 = this.uni[1][n161];
                                        final int n182 = 4;
                                        array32[n182] += this.bak_tbl2[this.uni[1][n161][2]];
                                    }
                                }
                            }
                        }
                    }
                    for (int n183 = 1; n183 < this.uni[0].length; ++n183) {
                        if (this.uni[0][n183][0] != 0) {
                            if (this.uni[0][n183][1] == 0) {
                                for (int n184 = 0; n184 < this.uni[1].length; ++n184) {
                                    if (this.syatei(0, n183, n184) == 1) {
                                        this.uni[0][n183][1] = 1;
                                        this.uni[0][n183][2] = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    for (int n185 = 1; n185 < this.uni[1].length; ++n185) {
                        if (this.uni[1][n185][0] != 0) {
                            if (this.uni[1][n185][1] == 0) {
                                for (int n186 = 0; n186 < this.uni[0].length; ++n186) {
                                    if (this.syatei(1, n185, n186) == 1) {
                                        this.uni[1][n185][1] = 1;
                                        this.uni[1][n185][2] = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    for (int n187 = 1; n187 < this.uni[0].length; ++n187) {
                        if (this.uni[0][n187][0] != 0) {
                            if (this.uni[0][n187][1] == 1) {
                                this.uni_a1(n187);
                                boolean b = false;
                                for (int n188 = 0; n188 < this.uni[1].length; ++n188) {
                                    if (this.syatei(0, n187, n188) == 1) {
                                        b = true;
                                        if (this.uni[0][n187][18] == 0) {
                                            this.uni[0][n187][1] = 2;
                                            this.uni[0][n187][2] = 0;
                                            break;
                                        }
                                    }
                                }
                                if (!b) {
                                    this.uni[0][n187][1] = 0;
                                    this.uni[0][n187][2] = 0;
                                }
                            }
                            if (this.uni[0][n187][1] == 2) {
                                this.uni_a1(n187);
                                if (this.uni[0][n187][2] == 0) {
                                    this.uni[0][n187][1] = 1;
                                }
                                else if (this.uni[0][n187][2] == this.uni[0][n187][21]) {
                                    this.uni[0][n187][18] = this.uni[0][n187][12];
                                    this.t_h2 = 0;
                                    for (int n189 = 0; n189 < this.uni[1].length; ++n189) {
                                        if (this.syatei(0, n187, n189) == 1) {
                                            this.t_h1[this.t_h2][0] = n189;
                                            this.t_h1[this.t_h2][1] = this.uni[1][n189][3] - this.uni[1][n189][14];
                                            ++this.t_h2;
                                        }
                                    }
                                    if (this.t_h2 > 0) {
                                        if (this.uni[0][n187][20] == 0) {
                                            for (int n190 = 0; n190 < this.t_h2 - 1; ++n190) {
                                                int n191 = this.t_h1[n190][1];
                                                int n192 = n190;
                                                for (int n193 = n190 + 1; n193 < this.t_h2; ++n193) {
                                                    if (this.t_h1[n193][1] > n191) {
                                                        n191 = this.t_h1[n193][1];
                                                        n192 = n193;
                                                    }
                                                }
                                                this.t_h1[51][0] = this.t_h1[n190][0];
                                                this.t_h1[51][1] = this.t_h1[n190][1];
                                                this.t_h1[n190][0] = this.t_h1[n192][0];
                                                this.t_h1[n190][1] = this.t_h1[n192][1];
                                                this.t_h1[n192][0] = this.t_h1[51][0];
                                                this.t_h1[n192][1] = this.t_h1[51][1];
                                            }
                                            final int n194 = this.t_h1[0][1];
                                            int n195 = 0;
                                            for (int n196 = 0; n196 < this.t_h2 && this.t_h1[n196][1] == n194; ++n196) {
                                                ++n195;
                                            }
                                            final int random2 = this.random(n195);
                                            if (this.uni[0][n187][17] != 0 && this.uni[0][n187][17] == this.uni[1][this.t_h1[random2][0]][16]) {
                                                final int[] array33 = this.uni[1][this.t_h1[random2][0]];
                                                final int n197 = 19;
                                                array33[n197] += this.uni[0][n187][11] * 5 / 10;
                                            }
                                            else if (this.uni[0][n187][16] != 0 && this.uni[0][n187][16] == this.uni[1][this.t_h1[random2][0]][17]) {
                                                final int[] array34 = this.uni[1][this.t_h1[random2][0]];
                                                final int n198 = 19;
                                                array34[n198] += this.uni[0][n187][11] * 15 / 10;
                                            }
                                            else {
                                                final int[] array35 = this.uni[1][this.t_h1[random2][0]];
                                                final int n199 = 19;
                                                array35[n199] += this.uni[0][n187][11];
                                            }
                                        }
                                        else {
                                            for (int n200 = 0; n200 < this.t_h2; ++n200) {
                                                if (this.uni[0][n187][17] != 0 && this.uni[0][n187][17] == this.uni[1][this.t_h1[n200][0]][16]) {
                                                    final int[] array36 = this.uni[1][this.t_h1[n200][0]];
                                                    final int n201 = 19;
                                                    array36[n201] += this.uni[0][n187][11] * 5 / 10;
                                                }
                                                if (this.uni[0][n187][16] != 0 && this.uni[0][n187][16] == this.uni[1][this.t_h1[n200][0]][17]) {
                                                    final int[] array37 = this.uni[1][this.t_h1[n200][0]];
                                                    final int n202 = 19;
                                                    array37[n202] += this.uni[0][n187][11] * 15 / 10;
                                                }
                                                else {
                                                    final int[] array38 = this.uni[1][this.t_h1[n200][0]];
                                                    final int n203 = 19;
                                                    array38[n203] += this.uni[0][n187][11];
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int n204 = 1; n204 < this.uni[1].length; ++n204) {
                        if (this.uni[1][n204][0] != 0) {
                            if (this.uni[1][n204][1] == 1) {
                                this.uni_a2(n204);
                                boolean b2 = false;
                                for (int n205 = 0; n205 < this.uni[0].length; ++n205) {
                                    if (this.syatei(1, n204, n205) == 1) {
                                        b2 = true;
                                        if (this.uni[1][n204][18] == 0) {
                                            this.uni[1][n204][1] = 2;
                                            this.uni[1][n204][2] = 0;
                                            break;
                                        }
                                    }
                                }
                                if (!b2) {
                                    this.uni[1][n204][1] = 0;
                                    this.uni[1][n204][2] = 0;
                                }
                            }
                            if (this.uni[1][n204][1] == 2) {
                                this.uni_a2(n204);
                                if (this.uni[1][n204][2] == 0) {
                                    this.uni[1][n204][1] = 1;
                                }
                                else if (this.uni[1][n204][2] == this.uni[1][n204][21]) {
                                    this.uni[1][n204][18] = this.uni[1][n204][12];
                                    this.t_h2 = 0;
                                    for (int n206 = 0; n206 < this.uni[0].length; ++n206) {
                                        if (this.syatei(1, n204, n206) == 1) {
                                            this.t_h1[this.t_h2][0] = n206;
                                            this.t_h1[this.t_h2][1] = this.uni[0][n206][3] + this.uni[0][n206][14];
                                            ++this.t_h2;
                                        }
                                    }
                                    if (this.t_h2 > 0) {
                                        if (this.uni[1][n204][20] == 0) {
                                            for (int n207 = 0; n207 < this.t_h2 - 1; ++n207) {
                                                int n208 = this.t_h1[n207][1];
                                                int n209 = n207;
                                                for (int n210 = n207 + 1; n210 < this.t_h2; ++n210) {
                                                    if (this.t_h1[n210][1] < n208) {
                                                        n208 = this.t_h1[n210][1];
                                                        n209 = n210;
                                                    }
                                                }
                                                this.t_h1[51][0] = this.t_h1[n207][0];
                                                this.t_h1[51][1] = this.t_h1[n207][1];
                                                this.t_h1[n207][0] = this.t_h1[n209][0];
                                                this.t_h1[n207][1] = this.t_h1[n209][1];
                                                this.t_h1[n209][0] = this.t_h1[51][0];
                                                this.t_h1[n209][1] = this.t_h1[51][1];
                                            }
                                            final int n211 = this.t_h1[0][1];
                                            int n212 = 0;
                                            for (int n213 = 0; n213 < this.t_h2 && this.t_h1[n213][1] == n211; ++n213) {
                                                ++n212;
                                            }
                                            final int random3 = this.random(n212);
                                            if (this.uni[1][n204][17] != 0 && this.uni[1][n204][17] == this.uni[0][this.t_h1[random3][0]][16]) {
                                                final int[] array39 = this.uni[0][this.t_h1[random3][0]];
                                                final int n214 = 19;
                                                array39[n214] += this.uni[1][n204][11] * 5 / 10;
                                            }
                                            else if (this.uni[1][n204][16] != 0 && this.uni[1][n204][16] == this.uni[0][this.t_h1[random3][0]][17]) {
                                                final int[] array40 = this.uni[0][this.t_h1[random3][0]];
                                                final int n215 = 19;
                                                array40[n215] += this.uni[1][n204][11] * 15 / 10;
                                            }
                                            else {
                                                final int[] array41 = this.uni[0][this.t_h1[random3][0]];
                                                final int n216 = 19;
                                                array41[n216] += this.uni[1][n204][11];
                                            }
                                        }
                                        else {
                                            for (int n217 = 0; n217 < this.t_h2; ++n217) {
                                                if (this.uni[1][n204][17] != 0 && this.uni[1][n204][17] == this.uni[0][this.t_h1[n217][0]][16]) {
                                                    final int[] array42 = this.uni[0][this.t_h1[n217][0]];
                                                    final int n218 = 19;
                                                    array42[n218] += this.uni[1][n204][11] * 5 / 10;
                                                }
                                                else if (this.uni[1][n204][16] != 0 && this.uni[1][n204][16] == this.uni[0][this.t_h1[n217][0]][17]) {
                                                    final int[] array43 = this.uni[0][this.t_h1[n217][0]];
                                                    final int n219 = 19;
                                                    array43[n219] += this.uni[1][n204][11] * 15 / 10;
                                                }
                                                else {
                                                    final int[] array44 = this.uni[0][this.t_h1[n217][0]];
                                                    final int n220 = 19;
                                                    array44[n220] += this.uni[1][n204][11];
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int n221 = 0; n221 < this.ef2.length; ++n221) {
                        if (this.ef2[n221][0] > 0) {
                            final int[] array45 = this.ef2[n221];
                            final int n222 = 0;
                            --array45[n222];
                            if (this.ef2[n221][0] == 4) {
                                for (int n223 = 1; n223 < this.uni[1].length; ++n223) {
                                    if (this.uni[1][n223][0] != 0) {
                                        if (this.uni[1][n223][1] <= 3 && this.uni[1][n223][22] < this.ef2[n221][2] && this.uni[1][n223][3] - this.uni[1][n223][14] >= this.ef2[n221][1] + 100) {
                                            this.uni[1][n223][22] = this.ef2[n221][2];
                                            if (this.uni[1][n223][1] <= 2) {
                                                final int[] array46 = this.uni[1][n223];
                                                final int n224 = 19;
                                                array46[n224] += this.uni[0][0][16];
                                                this.uni[1][n223][23] = 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    int n225 = 0;
                    for (int n226 = 0; n226 < 2; ++n226) {
                        for (int n227 = 0; n227 < this.uni[n226].length; ++n227) {
                            if (this.uni[n226][n227][0] != 0) {
                                if (this.uni[n226][n227][19] != 0) {
                                    this.ef1[n226][n227][0] = 6;
                                    if (n227 == 0) {
                                        n225 = 2;
                                        this.ef1[n226][0][1] = this.uni[n226][0][3] - 225 + (this.random(11) - 5) * 10;
                                        this.ef1[n226][0][2] = 1560 - this.random(10) * 10;
                                        this.uni[n226][0][5] = 1;
                                        if (this.uni[n226][0][1] == 0 || this.uni[n226][0][1] == 1) {
                                            this.uni[n226][0][1] = 1;
                                            this.uni[n226][0][2] = 4;
                                        }
                                    }
                                    else {
                                        if (n225 == 0) {
                                            n225 = 1;
                                        }
                                        this.ef1[n226][n227][1] = this.uni[n226][n227][3] - 225 + (this.random(11) - 5) * 10;
                                        this.ef1[n226][n227][2] = this.uni[n226][n227][4] - 470 + (this.random(11) - 5) * 10;
                                    }
                                    final int n228 = this.uni[n226][n227][8];
                                    final int[] array47 = this.uni[n226][n227];
                                    final int n229 = 8;
                                    array47[n229] -= this.uni[n226][n227][19];
                                    if (this.uni[n226][n227][8] <= 0) {
                                        this.uni[n226][n227][8] = 0;
                                    }
                                    if (n227 > 0) {
                                        int n230;
                                        int n231;
                                        for (n230 = this.uni[n226][n227][7] / this.uni[n226][n227][9], n231 = 0; n231 < this.uni[n226][n227][9] && this.uni[n226][n227][8] > n230 * n231; ++n231) {}
                                        int n232;
                                        for (n232 = 0; n232 < this.uni[n226][n227][9] && n228 > n230 * n232; ++n232) {}
                                        if (n231 != this.uni[n226][n227][9] && n231 != n232) {
                                            this.uni[n226][n227][1] = 3;
                                            this.uni[n226][n227][2] = 0;
                                        }
                                        else if (this.uni[n226][n227][23] == 1) {
                                            this.uni[n226][n227][1] = 5;
                                            this.uni[n226][n227][2] = 0;
                                        }
                                    }
                                    else if (this.uni[n226][n227][8] == 0 && this.p_flg[14] == 0) {
                                        this.p_flg[2] = 0;
                                        this.p_flg[15] = 0;
                                        this.p_flg[16] = 0;
                                        this.fe[0] = 0;
                                        this.fe[1] = 0;
                                        this.fe[2] = 0;
                                        this.fe[3] = -1;
                                        this.setSoftLabel(0, MyCanvas.soft_label[0] = "");
                                        this.setSoftLabel(1, MyCanvas.soft_label[1] = "");
                                        if (n226 == 0) {
                                            this.p_flg[12] = 1;
                                            this.play(9);
                                            for (int n233 = 1; n233 < this.uni[0].length; ++n233) {
                                                if (this.uni[0][n233][0] != 0 && this.uni[0][n233][1] != 4) {
                                                    this.uni[0][n233][1] = 4;
                                                    this.uni[0][n233][2] = 0;
                                                    this.uni[0][n233][8] = 0;
                                                    this.uni[0][n233][10] = (this.random(6) + 5) * 10;
                                                }
                                            }
                                            if (this.p_flg[0] != 48) {
                                                this.p_flg[14] = 2;
                                                this.p_flg[24] = 0;
                                                if (this.p_flg[0] != 0 && this.save3[23] == 0) {
                                                    this.p_flg[24] = 1;
                                                    this.save3[23] = 1;
                                                }
                                            }
                                            else {
                                                this.p_flg[14] = 5;
                                                final int[] p_flg75 = this.p_flg;
                                                final int n234 = 22;
                                                p_flg75[n234] += 100000 - this.uni[1][0][8];
                                                final int[] p_flg76 = this.p_flg;
                                                final int n235 = 22;
                                                p_flg76[n235] += this.p_flg[26];
                                                this.p_flg[23] = 0;
                                                if (this.save0[1] < this.p_flg[22]) {
                                                    this.save0[1] = this.p_flg[22];
                                                    this.p_flg[23] = 1;
                                                }
                                                this.save();
                                            }
                                        }
                                        else {
                                            this.p_flg[12] = 2;
                                            this.play(8);
                                            for (int n236 = 1; n236 < this.uni[1].length; ++n236) {
                                                if (this.uni[1][n236][0] != 0 && this.uni[1][n236][1] != 4) {
                                                    this.uni[1][n236][1] = 4;
                                                    this.uni[1][n236][2] = 0;
                                                    this.uni[1][n236][8] = 0;
                                                    this.uni[1][n236][10] = (this.random(6) + 5) * 10;
                                                }
                                            }
                                            if (this.p_flg[0] != 48) {
                                                this.p_flg[14] = 1;
                                                final int n237 = 1000 + 300 * this.p_flg[0];
                                                this.p_flg[17] = n237 - n237 * ((this.save4[this.p_flg[0]] > 7) ? 7 : this.save4[this.p_flg[0]]) / 8;
                                                this.p_flg[17] = this.p_flg[17] * (this.nyan13[this.save3[10]] + this.ta7[3] * this.p_flg3[3] / 100) / 100;
                                                final int[] save7 = this.save3;
                                                final int n238 = 0;
                                                save7[n238] += this.p_flg[17];
                                                if (this.save3[0] > 9999999) {
                                                    this.save3[0] = 9999999;
                                                }
                                                this.p_flg[21] = 0;
                                                if (this.save3[1] == this.p_flg[0]) {
                                                    final int[] save8 = this.save3;
                                                    final int n239 = 1;
                                                    ++save8[n239];
                                                    this.syoki_iti = -1;
                                                    if (this.save3[1] == 48) {
                                                        this.p_flg[21] = 1;
                                                    }
                                                }
                                                final int[] save9 = this.save4;
                                                final int n240 = this.p_flg[0];
                                                ++save9[n240];
                                                if (this.save4[this.p_flg[0]] > 99) {
                                                    this.save4[this.p_flg[0]] = 99;
                                                }
                                            }
                                            else {
                                                this.p_flg[14] = 4;
                                                final int[] p_flg77 = this.p_flg;
                                                final int n241 = 22;
                                                p_flg77[n241] += 100000;
                                                final int n242 = this.p_flg[1] / 15;
                                                int n243 = 820000 - n242 * n242;
                                                if (n243 < 0) {
                                                    n243 = 0;
                                                }
                                                final int[] p_flg78 = this.p_flg;
                                                final int n244 = 22;
                                                p_flg78[n244] += n243;
                                                final int[] p_flg79 = this.p_flg;
                                                final int n245 = 22;
                                                p_flg79[n245] += this.uni[0][0][8];
                                                final int[] p_flg80 = this.p_flg;
                                                final int n246 = 22;
                                                p_flg80[n246] += this.p_flg[26];
                                                this.p_flg[23] = 0;
                                                if (this.save0[1] < this.p_flg[22]) {
                                                    this.save0[1] = this.p_flg[22];
                                                    this.p_flg[23] = 1;
                                                }
                                                this.save();
                                            }
                                        }
                                    }
                                    else if (n226 == 1 && this.tizu5[this.p_flg[0] * 3 + 1] > 0 && this.tizu5[this.p_flg[0] * 3 + 1] <= 99) {
                                        final int n247 = this.uni[n226][n227][7] * this.tizu5[this.p_flg[0] * 3 + 1] / 100;
                                        if (n228 > n247 && this.uni[n226][n227][8] <= n247) {
                                            this.fe[0] = 1;
                                            this.fe[1] = 0;
                                            this.fe[2] = 45;
                                            this.fe[3] = this.tizu5[this.p_flg[0] * 3 + 2];
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.p_flg[14] == 0) {
                        if (n225 == 1) {
                            this.play(20 + this.random(2));
                        }
                        else if (n225 == 2 && MyCanvas.snd_val[0] > 3) {
                            MyCanvas.snd_opt[3] = 3;
                            this.play(22);
                        }
                        for (int n248 = 2; n248 < 11; ++n248) {
                            if (this.p_flg2[n248][1] > 0) {
                                final int[] array48 = this.p_flg2[n248];
                                final int n249 = 1;
                                --array48[n249];
                                if (this.p_flg2[n248][1] == 0 && this.p_flg[2] == 1) {
                                    this.play(27);
                                }
                            }
                        }
                        final int[] p_flg81 = this.p_flg;
                        final int n250 = 10;
                        p_flg81[n250] += this.p_flg[8];
                        if (this.p_flg[10] > this.p_flg[9]) {
                            this.p_flg[10] = this.p_flg[9];
                        }
                        if (this.uni[0][0][12] > 0) {
                            final int[] array49 = this.uni[0][0];
                            final int n251 = 12;
                            --array49[n251];
                            if (this.uni[0][0][12] == 0) {
                                this.play(28);
                            }
                        }
                    }
                    if (this.c_dai[1] > 0) {
                        final int[] c_dai2 = this.c_dai;
                        final int n252 = 1;
                        --c_dai2[n252];
                        if (this.c_dai[1] == 0) {
                            this.c_dai[0] = 0;
                        }
                    }
                    if (this.p_flg[25] > 0) {
                        final int[] p_flg82 = this.p_flg;
                        final int n253 = 25;
                        --p_flg82[n253];
                    }
                    for (int n254 = 0; n254 < this.ef1.length; ++n254) {
                        for (int n255 = 0; n255 < this.ef1[n254].length; ++n255) {
                            if (this.ef1[n254][n255][0] > 0) {
                                final int[] array50 = this.ef1[n254][n255];
                                final int n256 = 0;
                                --array50[n256];
                            }
                        }
                    }
                    if (this.dat[4] == 2) {
                        for (int n257 = 0; n257 < this.hosi.length; ++n257) {
                            this.hosi[n257][2] = (this.hosi[n257][2] + this.hosi[n257][3]) % 200;
                        }
                        break;
                    }
                    if (this.dat[4] == 3) {
                        for (int n258 = 0; n258 < this.yuki.length; ++n258) {
                            final int[] array51 = this.yuki[n258];
                            final int n259 = 0;
                            array51[n259] += this.cos(this.yuki[n258][2]) * this.yuki[n258][3] / 4096;
                            this.yuki[n258][0] = (this.yuki[n258][0] + 28000) % 28000;
                            final int[] array52 = this.yuki[n258];
                            final int n260 = 1;
                            array52[n260] += this.sin(this.yuki[n258][2]) * this.yuki[n258][3] / 4096;
                            if (this.yuki[n258][1] >= 26000) {
                                this.yuki[n258][1] = -2000;
                                this.yuki[n258][2] = 374 - this.random(100);
                                this.yuki[n258][3] = 200 + this.random(600);
                            }
                        }
                        break;
                    }
                    break;
                }
                case 500: {
                    final int[] p_flg83 = this.p_flg;
                    final int n261 = 4;
                    --p_flg83[n261];
                    if (this.p_flg[4] < 0) {
                        this.p_flg[3] = this.random(2);
                        if (this.p_flg[3] == 0) {
                            this.p_flg[4] = 30;
                        }
                        else {
                            this.p_flg[4] = 60;
                        }
                    }
                    for (int n262 = 0; n262 < this.hinoko.length; ++n262) {
                        final int[] array53 = this.hinoko[n262];
                        final int n263 = 2;
                        ++array53[n263];
                        final int[] array54 = this.hinoko[n262];
                        final int n264 = 1;
                        array54[n264] -= this.hinoko[n262][3];
                        if (this.hinoko[n262][1] <= 5000) {
                            this.hinoko[n262][0] = (n262 * 48 + this.random(48)) % 240 * 100;
                            this.hinoko[n262][1] = (240 + this.random(50)) * 100;
                            this.hinoko[n262][2] = 0;
                            this.hinoko[n262][3] = (1 + this.random(50)) * 10;
                            this.hinoko[n262][4] = (1 + this.random(6)) * 100;
                            this.hinoko[n262][5] = 5 + this.random(15);
                        }
                    }
                    if (this.p_flg[0] == 0) {
                        final int[] p_flg84 = this.p_flg;
                        final int n265 = 1;
                        ++p_flg84[n265];
                        if (this.p_flg[1] >= 50) {
                            this.p_flg[0] = 1;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                        }
                    }
                    else {
                        final int[] p_flg85 = this.p_flg;
                        final int n266 = 2;
                        ++p_flg85[n266];
                        if (this.p_flg[0] == 1 && (this.op_moji.length - 1) * 16 + 240 - this.p_flg[2] <= 114) {
                            this.p_flg[0] = 2;
                            this.p_flg[1] = 0;
                        }
                        if (this.p_flg[0] == 2) {
                            final int[] p_flg86 = this.p_flg;
                            final int n267 = 1;
                            ++p_flg86[n267];
                            if (this.p_flg[1] >= 80) {
                                this.setScene(100);
                                this.play(1);
                            }
                        }
                    }
                    if ((MyCanvas.sivar[13] & 0x500020) != 0x0) {
                        this.setScene(100);
                        this.play(1);
                        break;
                    }
                    break;
                }
                case 501: {
                    for (int n268 = 0; n268 < this.hinoko.length; ++n268) {
                        final int[] array55 = this.hinoko[n268];
                        final int n269 = 2;
                        ++array55[n269];
                        final int[] array56 = this.hinoko[n268];
                        final int n270 = 1;
                        array56[n270] -= this.hinoko[n268][3];
                        if (this.hinoko[n268][1] <= 5000) {
                            this.hinoko[n268][0] = (n268 * 48 + this.random(48)) % 240 * 100;
                            this.hinoko[n268][1] = (240 + this.random(50)) * 100;
                            this.hinoko[n268][2] = 0;
                            this.hinoko[n268][3] = (1 + this.random(50)) * 10;
                            this.hinoko[n268][4] = (1 + this.random(6)) * 100;
                            this.hinoko[n268][5] = 5 + this.random(15);
                        }
                    }
                    if (this.p_flg[0] == 0) {
                        final int[] p_flg87 = this.p_flg;
                        final int n271 = 1;
                        ++p_flg87[n271];
                        if (this.p_flg[1] >= 50) {
                            this.p_flg[0] = 1;
                            this.p_flg[1] = 0;
                            this.p_flg[2] = 0;
                            break;
                        }
                        break;
                    }
                    else if (this.p_flg[0] == 1) {
                        final int[] p_flg88 = this.p_flg;
                        final int n272 = 2;
                        ++p_flg88[n272];
                        final int n273 = this.ed_moji.length * 16 + 240 - this.p_flg[2];
                        if (n273 <= 92) {
                            final int[] p_flg89 = this.p_flg;
                            final int n274 = 2;
                            p_flg89[n274] += 92 - n273;
                            this.p_flg[0] = 2;
                            this.p_flg[1] = 0;
                            break;
                        }
                        break;
                    }
                    else if (this.p_flg[0] == 2) {
                        final int[] p_flg90 = this.p_flg;
                        final int n275 = 1;
                        ++p_flg90[n275];
                        if (this.p_flg[1] >= 75) {
                            this.p_flg[0] = 3;
                            this.p_flg[1] = 0;
                            break;
                        }
                        break;
                    }
                    else {
                        if (this.p_flg[0] != 3) {
                            break;
                        }
                        final int[] p_flg91 = this.p_flg;
                        final int n276 = 1;
                        ++p_flg91[n276];
                        if (this.p_flg[1] >= 50) {
                            this.setScene(502);
                            this.play(-2);
                            this.p_flg[0] = 0;
                            this.p_flg[1] = 0;
                            break;
                        }
                        break;
                    }
                }
                case 502: {
                    this.p_flg[5] = (this.p_flg[5] + 1) % 2;
                    if (this.p_flg[0] == 0) {
                        final int[] p_flg92 = this.p_flg;
                        final int n277 = 1;
                        ++p_flg92[n277];
                        if (this.p_flg[1] >= 30 && (MyCanvas.sivar[13] & 0x100020) != 0x0) {
                            this.p_flg[0] = 1;
                            this.p_flg[1] = 0;
                            this.play(11);
                            break;
                        }
                        break;
                    }
                    else {
                        if (this.p_flg[0] != 1) {
                            break;
                        }
                        final int[] p_flg93 = this.p_flg;
                        final int n278 = 1;
                        ++p_flg93[n278];
                        if (this.p_flg[1] >= 2) {
                            for (int n279 = 0; n279 < MyCanvas.img.length; ++n279) {
                                if (MyCanvas.bunrui[n279] == 2 || MyCanvas.bunrui[n279] == 3) {
                                    this.g_free(n279);
                                }
                            }
                            for (int n280 = 0; n280 < MyCanvas.img.length; ++n280) {
                                if (MyCanvas.bunrui[n280] == 1) {
                                    this.g_load(n280);
                                }
                            }
                            MyCanvas.slvar[0] = 0L;
                            this.setScene(100);
                            this.p_flg[0] = 100;
                            this.p_flg[4] = 1;
                            this.p_flg[22] = this.save3[0];
                            this.play(2);
                            break;
                        }
                        break;
                    }
                }
                case 0: {
                    this.myPaint();
                    try {
                        MyCanvas.snd_val[2] = (MyCanvas.snd_val[3] = 50);
                        MyCanvas.is = Connector.openInputStream("scratchpad:///0;pos=0");
                        MyCanvas.sivar[6] = this.readData(MyCanvas.is, 1);
                        if (MyCanvas.sivar[6] == 1) {
                            MyCanvas.sivar[7] = this.readData(MyCanvas.is, 1);
                            MyCanvas.sivar[8] = this.readData(MyCanvas.is, 1);
                            MyCanvas.snd_val[2] = this.readData(MyCanvas.is, 1);
                            MyCanvas.snd_val[3] = this.readData(MyCanvas.is, 1);
                            this.save0[0] = this.readData(MyCanvas.is, 1);
                            for (int n281 = 1; n281 < 4; ++n281) {
                                this.save0[n281] = this.readData(MyCanvas.is, 4);
                            }
                            for (int n282 = 4; n282 < this.save0.length; ++n282) {
                                this.save0[n282] = this.readData(MyCanvas.is, 1);
                            }
                            this.save1[0] = this.readData(MyCanvas.is, 4);
                            for (int n283 = 1; n283 < this.save1.length; ++n283) {
                                this.save1[n283] = this.readData(MyCanvas.is, 1);
                            }
                            for (int n284 = 0; n284 < this.save2.length; ++n284) {
                                this.save2[n284] = this.readData(MyCanvas.is, 1);
                            }
                            for (int n285 = 0; n285 < this.save5.length; ++n285) {
                                this.save5[n285] = this.readData(MyCanvas.is, 1);
                            }
                            this.taikenban = this.readData(MyCanvas.is, 1);
                        }
                        else {
                            for (int n286 = 0; n286 < this.save0.length; ++n286) {
                                this.save0[n286] = 0;
                            }
                            for (int n287 = 0; n287 < this.save1.length; ++n287) {
                                this.save1[n287] = 0;
                            }
                            for (int n288 = 0; n288 < this.save2.length; ++n288) {
                                this.save2[n288] = 0;
                            }
                            for (int n289 = 0; n289 < this.save5.length; ++n289) {
                                this.save5[n289] = 0;
                            }
                            this.save1[13] = 1;
                            this.taikenban = 0;
                        }
                        MyCanvas.is.close();
                    }
                    catch (final Exception ex) {}
                    this.taiken_flg = 0;
                    this.save();
                    if (MyCanvas.sivar[0] == 0 && MyCanvas.sivar[7] != 1) {
                        this.taikenkokuti();
                        try {
                            final byte[] array57 = new byte[153600];
                            MyCanvas.sivar[17] = (MyCanvas.sivar[18] = 0);
                            this.setScene(1);
                            this.myPaint();
                            MyCanvas.os = Connector.openOutputStream("scratchpad:///0;pos=1000");
                            for (int n290 = 0; MyCanvas.sivar[17] == 0 || n290 < MyCanvas.sivar[17]; ++n290) {
                                (MyCanvas.hc = (HttpConnection)Connector.open(MyCanvas.url2[0] + MyCanvas.url[2] + "/data.0" + n290 / 10 % 10 + n290 % 10, 1)).setRequestMethod("GET");
                                MyCanvas.hc.connect();
                                MyCanvas.is = MyCanvas.hc.openInputStream();
                                if (n290 == 0) {
                                    this.writeData(MyCanvas.os, array2[0] = this.readData(MyCanvas.is, 2), 2);
                                    this.writeData(MyCanvas.os, array2[1] = this.readData(MyCanvas.is, 4), 4);
                                    array2[0] = 11 + array2[0] * 4 + array2[1];
                                    MyCanvas.sivar[17] = (array2[0] - 1) / 153600 + 1;
                                }
                                if (array2[0] - n290 * 153600 > 153600) {
                                    array2[1] = 153600;
                                }
                                else {
                                    array2[1] = array2[0] - n290 * 153600;
                                }
                                if (n290 == 0) {
                                    final int[] array58 = array2;
                                    final int n291 = 1;
                                    array58[n291] -= 6;
                                }
                                MyCanvas.is.read(array57, 0, array2[1]);
                                MyCanvas.os.write(array57, 0, array2[1]);
                                MyCanvas.is.close();
                                MyCanvas.hc.close();
                                final int[] sivar2 = MyCanvas.sivar;
                                final int n292 = 18;
                                ++sivar2[n292];
                                this.myPaint();
                            }
                            MyCanvas.os.close();
                        }
                        catch (final Exception ex2) {
                            this.setScene(10);
                            break;
                        }
                    }
                    if (MyCanvas.sivar[0] == 1) {
                        MyCanvas.sivar[7] = 1;
                        this.save();
                    }
                    try {
                        MyCanvas.is = Connector.openInputStream("scratchpad:///0;pos=1000");
                        (MyCanvas.data_offset = new int[this.readData(MyCanvas.is, 2) + 1])[MyCanvas.data_offset.length - 1] = this.readData(MyCanvas.is, 4);
                        MyCanvas.img = new Image[this.readData(MyCanvas.is, 2)];
                        MyCanvas.mimg = new MediaImage[MyCanvas.img.length];
                        MyCanvas.snd = new MediaSound[this.readData(MyCanvas.is, 1)];
                        MyCanvas.tex = new Texture[this.readData(MyCanvas.is, 1)];
                        MyCanvas.etex = new Texture[this.readData(MyCanvas.is, 1)];
                        for (int n293 = 0; n293 < MyCanvas.data_offset.length - 1; ++n293) {
                            MyCanvas.data_offset[n293] = this.readData(MyCanvas.is, 4);
                        }
                        MyCanvas.is.close();
                    }
                    catch (final Exception ex3) {}
                    Label_23137: {
                        if (MyCanvas.img.length <= 0 && MyCanvas.snd.length <= 0 && MyCanvas.tex.length <= 0) {
                            if (MyCanvas.etex.length <= 0) {
                                break Label_23137;
                            }
                        }
                        try {
                            MyCanvas.sivar[17] = 0;
                            for (int n294 = 0; n294 < MyCanvas.img.length; ++n294) {
                                MyCanvas.img[n294] = null;
                                MyCanvas.mimg[n294] = null;
                                if (MyCanvas.bunrui[n294] == 0 || MyCanvas.bunrui[n294] == 1) {
                                    final int[] sivar3 = MyCanvas.sivar;
                                    final int n295 = 17;
                                    ++sivar3[n295];
                                }
                            }
                            final int[] sivar4 = MyCanvas.sivar;
                            final int n296 = 17;
                            sivar4[n296] += MyCanvas.snd.length + MyCanvas.tex.length + MyCanvas.etex.length;
                            MyCanvas.sivar[18] = (array2[0] = 0);
                            this.setScene(2);
                            for (int n297 = 0; n297 < MyCanvas.img.length; ++n297) {
                                if (MyCanvas.data_offset[n297 + 1] - MyCanvas.data_offset[n297] > 0 && MyCanvas.bunrui[n297] == 0) {
                                    this.g_load(n297);
                                    final int[] sivar5 = MyCanvas.sivar;
                                    final int n298 = 18;
                                    ++sivar5[n298];
                                }
                                if (100 * MyCanvas.sivar[18] / MyCanvas.sivar[17] > array2[0]) {
                                    this.myPaint();
                                    final int[] array59 = array2;
                                    final int n299 = 0;
                                    array59[n299] += 5;
                                }
                            }
                            for (int n300 = 0; n300 < MyCanvas.img.length; ++n300) {
                                if (MyCanvas.data_offset[n300 + 1] - MyCanvas.data_offset[n300] > 0 && MyCanvas.bunrui[n300] == 1) {
                                    this.g_load(n300);
                                    final int[] sivar6 = MyCanvas.sivar;
                                    final int n301 = 18;
                                    ++sivar6[n301];
                                }
                                if (100 * MyCanvas.sivar[18] / MyCanvas.sivar[17] > array2[0]) {
                                    this.myPaint();
                                    final int[] array60 = array2;
                                    final int n302 = 0;
                                    array60[n302] += 5;
                                }
                            }
                            MyCanvas.is = Connector.openInputStream("scratchpad:///0;pos=" + (1011 + (MyCanvas.data_offset.length - 1) * 4 + MyCanvas.data_offset[MyCanvas.data_offset.length - 2]) + ",length=" + (MyCanvas.data_offset[MyCanvas.data_offset.length - 1] - MyCanvas.data_offset[MyCanvas.data_offset.length - 2]));
                            final JarInflater jarInflater = new JarInflater(MyCanvas.is);
                            int[] sivar7;
                            int n305;
                            for (int n303 = 0; n303 < MyCanvas.snd.length; ++n303, sivar7 = MyCanvas.sivar, n305 = 18, ++sivar7[n305]) {
                                final InputStream inputStream = jarInflater.getInputStream("snd0" + n303 / 10 + n303 % 10 + ".mld");
                                (MyCanvas.snd[n303] = MediaManager.getSound(inputStream)).use();
                                inputStream.close();
                                if (100 * MyCanvas.sivar[18] / MyCanvas.sivar[17] > array2[0]) {
                                    this.myPaint();
                                    final int[] array61 = array2;
                                    final int n304 = 0;
                                    array61[n304] += 5;
                                }
                            }
                            int[] sivar8;
                            int n308;
                            for (int n306 = 0; n306 < MyCanvas.tex.length; ++n306, sivar8 = MyCanvas.sivar, n308 = 18, ++sivar8[n308]) {
                                final InputStream inputStream2 = jarInflater.getInputStream("tex0" + n306 / 10 + n306 % 10 + ".bmp");
                                MyCanvas.tex[n306] = new Texture(inputStream2, false);
                                inputStream2.close();
                                if (100 * MyCanvas.sivar[18] / MyCanvas.sivar[17] > array2[0]) {
                                    this.myPaint();
                                    final int[] array62 = array2;
                                    final int n307 = 0;
                                    array62[n307] += 5;
                                }
                            }
                            int[] sivar9;
                            int n311;
                            for (int n309 = 0; n309 < MyCanvas.etex.length; ++n309, sivar9 = MyCanvas.sivar, n311 = 18, ++sivar9[n311]) {
                                final InputStream inputStream3 = jarInflater.getInputStream("etex0" + n309 / 10 + n309 % 10 + ".bmp");
                                MyCanvas.etex[n309] = new Texture(inputStream3, true);
                                inputStream3.close();
                                if (100 * MyCanvas.sivar[18] / MyCanvas.sivar[17] > array2[0]) {
                                    this.myPaint();
                                    final int[] array63 = array2;
                                    final int n310 = 0;
                                    array63[n310] += 5;
                                }
                            }
                            jarInflater.close();
                            MyCanvas.is.close();
                        }
                        catch (final Exception ex4) {
                            this.setScene(11);
                            break;
                        }
                    }
                    if (MyCanvas.snd.length > 0) {
                        try {
                            try {
                                while (true) {
                                    final int[] snd_val = MyCanvas.snd_val;
                                    final int n312 = 0;
                                    ++snd_val[n312];
                                    AudioPresenter.getAudioPresenter(MyCanvas.snd_val[0] - 1);
                                }
                            }
                            catch (final Exception ex5) {
                                final int[] snd_val2 = MyCanvas.snd_val;
                                final int n313 = 0;
                                --snd_val2[n313];
                                MyCanvas.snd_data = new int[15][MyCanvas.snd_val[0]];
                                MyCanvas.snd_time = new long[MyCanvas.snd_val[0]];
                                MyCanvas.mml = new MyMediaListener[MyCanvas.snd_val[0]];
                                MyCanvas.audio = new AudioPresenter[MyCanvas.snd_val[0]];
                                for (int n314 = 0; n314 < MyCanvas.snd_val[0]; ++n314) {
                                    final int[] array64 = MyCanvas.snd_data[0];
                                    final int n315 = n314;
                                    final int[] array65 = MyCanvas.snd_data[2];
                                    final int n316 = n314;
                                    final int[] array66 = MyCanvas.snd_data[5];
                                    final int n317 = n314;
                                    final int[] array67 = MyCanvas.snd_data[3];
                                    final int n318 = n314;
                                    final int n319 = -1;
                                    array66[n317] = (array67[n318] = n319);
                                    array64[n315] = (array65[n316] = n319);
                                    MyCanvas.snd_data[6][n314] = 1;
                                    MyCanvas.mml[n314] = new MyMediaListener();
                                }
                                MyCanvas.snd_data[1][0] = 1;
                                for (int n320 = 1; n320 < MyCanvas.snd_val[0]; ++n320) {
                                    MyCanvas.snd_data[1][n320] = 2;
                                }
                                for (int n321 = 0; n321 < MyCanvas.snd_val[0]; ++n321) {
                                    (MyCanvas.audio[n321] = AudioPresenter.getAudioPresenter(n321)).setMediaListener((MediaListener)MyCanvas.mml[n321]);
                                    MyCanvas.audio[n321].setSound((n321 < MyCanvas.snd.length) ? MyCanvas.snd[n321] : MyCanvas.snd[MyCanvas.snd.length - 1]);
                                }
                                MyCanvas.snd_opt[0] = 100;
                                MyCanvas.snd_opt[4] = 100;
                                MyCanvas.snd_opt[5] = 0;
                                MyCanvas.snd_opt[6] = 0;
                                MyCanvas.snd_opt[1] = 0;
                                MyCanvas.snd_opt[2] = 0;
                                MyCanvas.snd_opt[3] = -1;
                                MyCanvas.snd_val[1] = 1;
                            }
                        }
                        catch (final Exception ex6) {}
                    }
                    if (MyCanvas.sivar[0] == 2) {
                        for (int n322 = 0; n322 < this.p_flg.length; ++n322) {
                            this.p_flg[n322] = 0;
                        }
                        this.setScene(500);
                        this.play(0);
                    }
                    System.gc();
                    break;
                }
                case 10:
                case 11: {
                    if ((MyCanvas.sivar[13] & 0x300020) != 0x0) {
                        Main.getCurrentApp().terminate();
                        break;
                    }
                    break;
                }
                case 12: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] == 0) {
                        Main.getCurrentApp().launch(1, new String[] { MyCanvas.url[1] + "?uid=NULLGWDOCOMO" });
                        MyCanvas.sivar[14] = 0;
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x200000) != 0x0 || ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] != 0)) {
                        Main.getCurrentApp().terminate();
                        break;
                    }
                    break;
                }
                case 150: {
                    if ((MyCanvas.sivar[13] & 0x200000) != 0x0 || ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u9589\u3058\u308b"))) {
                        this.play(-3);
                        this.play(12);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x100020) == 0x0) {
                        break;
                    }
                    this.play(11);
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u7d42\u4e86")) {
                        Main.getCurrentApp().terminate();
                        break;
                    }
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u8a2d\u5b9a")) {
                        this.setScene(151, -1);
                        break;
                    }
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u30a2\u30af\u30bb\u30b9")) {
                        this.setScene(152, -1);
                        break;
                    }
                    break;
                }
                case 155: {
                    if ((MyCanvas.sivar[13] & 0x200000) != 0x0 || ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u9589\u3058\u308b"))) {
                        this.play(-3);
                        this.play(12);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x100020) == 0x0) {
                        break;
                    }
                    this.play(11);
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u30bf\u30a4\u30c8\u30eb")) {
                        int n323 = 0;
                        for (int n324 = 0; n324 < this.save1.length; ++n324) {
                            if (this.save1[n324] != this.save3[n324]) {
                                n323 = 1;
                            }
                        }
                        for (int n325 = 0; n325 < this.save2.length; ++n325) {
                            if (this.save2[n325] != this.save4[n325]) {
                                n323 = 1;
                            }
                        }
                        for (int n326 = 0; n326 < this.save5.length; ++n326) {
                            if (this.save5[n326] != this.save6[n326]) {
                                n323 = 1;
                            }
                        }
                        if (n323 == 1) {
                            this.setScene(157, -1);
                            break;
                        }
                        this.setScene(100);
                        this.play(1);
                        break;
                    }
                    else {
                        if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u8a2d\u5b9a")) {
                            this.setScene(156, -1);
                            break;
                        }
                        break;
                    }
                }
                case 157: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] == 0) {
                        this.play(11);
                        for (int n327 = 0; n327 < this.save1.length; ++n327) {
                            this.save3[n327] = this.save1[n327];
                        }
                        for (int n328 = 0; n328 < this.save2.length; ++n328) {
                            this.save4[n328] = this.save2[n328];
                        }
                        for (int n329 = 0; n329 < this.save5.length; ++n329) {
                            this.save6[n329] = this.save5[n329];
                        }
                        this.takara_s();
                        this.setScene(100);
                        this.play(1);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x300020) != 0x0) {
                        this.play(12);
                        this.setScene(155, -1);
                        MyCanvas.wnd_default = "\u30bf\u30a4\u30c8\u30eb";
                        break;
                    }
                    break;
                }
                case 158: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] == 0) {
                        this.play(11);
                        for (int n330 = 0; n330 < this.save1.length; ++n330) {
                            this.save1[n330] = this.save3[n330];
                        }
                        for (int n331 = 0; n331 < this.save2.length; ++n331) {
                            this.save2[n331] = this.save4[n331];
                        }
                        for (int n332 = 0; n332 < this.save5.length; ++n332) {
                            this.save5[n332] = this.save6[n332];
                        }
                        this.save();
                        this.setScene(159, -1);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x300020) != 0x0) {
                        this.play(12);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    break;
                }
                case 159: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                        this.play(11);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    break;
                }
                case 350: {
                    if ((MyCanvas.sivar[13] & 0x200000) != 0x0 || ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u9589\u3058\u308b"))) {
                        this.play(-3);
                        this.play(12);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x100020) == 0x0) {
                        break;
                    }
                    this.play(11);
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u6226\u95d8\u4e2d\u6b62")) {
                        this.setScene(352, -1);
                        break;
                    }
                    if (MyCanvas.wnd_str[1][MyCanvas.wnd_param[6][0]].equals("\u8a2d\u5b9a")) {
                        this.setScene(351, -1);
                        break;
                    }
                    break;
                }
                case 352: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] == 0) {
                        this.play(11);
                        this.fe[0] = 0;
                        this.fe[1] = 0;
                        this.fe[2] = 0;
                        this.fe[3] = -1;
                        this.setScene(402);
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x300020) != 0x0) {
                        this.play(12);
                        this.setScene(350, -1);
                        MyCanvas.wnd_default = "\u6226\u95d8\u4e2d\u6b62";
                        break;
                    }
                    break;
                }
                case 151:
                case 153:
                case 156:
                case 351: {
                    MyCanvas.snd_val[2] = MyCanvas.item_param[2][0][0] * 5;
                    MyCanvas.snd_val[3] = MyCanvas.item_param[2][0][1] * 5;
                    if ((MyCanvas.sivar[13] & 0x300020) == 0x0) {
                        break;
                    }
                    this.play(12);
                    this.save();
                    if (MyCanvas.sivar[0] == 151) {
                        this.setScene(150, -1);
                        MyCanvas.wnd_default = "\u8a2d\u5b9a";
                        break;
                    }
                    if (MyCanvas.sivar[0] == 153) {
                        this.play(-3);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    if (MyCanvas.sivar[0] == 156) {
                        this.setScene(155, -1);
                        MyCanvas.wnd_default = "\u8a2d\u5b9a";
                        break;
                    }
                    if (MyCanvas.sivar[0] == 351) {
                        this.setScene(350, -1);
                        MyCanvas.wnd_default = "\u8a2d\u5b9a";
                        break;
                    }
                    break;
                }
                case 160: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0) {
                        this.setScene(161, -1);
                        this.play(11);
                        break;
                    }
                    break;
                }
                case 152:
                case 154:
                case 161: {
                    if ((MyCanvas.sivar[13] & 0x100020) != 0x0 && MyCanvas.wnd_param[6][0] == 0) {
                        if (MyCanvas.sivar[0] == 161) {
                            for (int n333 = 0; n333 < this.save1.length; ++n333) {
                                this.save1[n333] = this.save3[n333];
                            }
                            for (int n334 = 0; n334 < this.save2.length; ++n334) {
                                this.save2[n334] = this.save4[n334];
                            }
                            for (int n335 = 0; n335 < this.save5.length; ++n335) {
                                this.save5[n335] = this.save6[n335];
                            }
                            this.save();
                        }
                        Main.getCurrentApp().launch(1, new String[] { MyCanvas.url[1] + "?uid=NULLGWDOCOMO&ref=" + MyCanvas.url[2] });
                        MyCanvas.sivar[14] = 0;
                        break;
                    }
                    if ((MyCanvas.sivar[13] & 0x300020) == 0x0) {
                        break;
                    }
                    this.play(12);
                    if (MyCanvas.sivar[0] == 152) {
                        this.setScene(150, -1);
                        MyCanvas.wnd_default = "\u30a2\u30af\u30bb\u30b9";
                        break;
                    }
                    if (MyCanvas.sivar[0] == 154 || MyCanvas.sivar[0] == 161) {
                        this.play(-3);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    break;
                }
                case 250: {
                    try {
                        (MyCanvas.hc = (HttpConnection)Connector.open(MyCanvas.url[1] + "appli/505/" + MyCanvas.url[2] + "/rank.php?uid=NULLGWDOCOMO&score=" + this.save0[1], 1)).setRequestMethod("GET");
                        MyCanvas.hc.connect();
                        MyCanvas.is = MyCanvas.hc.openInputStream();
                        array2[0] = MyCanvas.is.read();
                        if ((char)array2[0] == '1') {
                            this.save0[2] = this.readData(MyCanvas.is, 4);
                            this.save0[3] = this.readData(MyCanvas.is, 4);
                            this.save();
                            this.p_flg[26] = 7;
                            MyCanvas.wnd_param[6][1] = 0;
                            MyCanvas.sivar[0] = MyCanvas.sivar[1];
                            MyCanvas.sivar[2] = MyCanvas.sivar[3];
                            this.setSoftLabel(0, MyCanvas.soft_label[0]);
                            this.setSoftLabel(1, MyCanvas.soft_label[1]);
                            MyCanvas.slvar[0] = 0L;
                        }
                        else {
                            this.setScene(251, -1);
                        }
                        MyCanvas.is.close();
                        MyCanvas.hc.close();
                    }
                    catch (final Exception ex7) {
                        this.setScene(251, -1);
                    }
                    break;
                }
                case 251: {
                    if ((MyCanvas.sivar[13] & 0x300020) != 0x0) {
                        this.play(12);
                        MyCanvas.wnd_param[6][1] = 0;
                        MyCanvas.sivar[0] = MyCanvas.sivar[1];
                        MyCanvas.sivar[2] = MyCanvas.sivar[3];
                        this.setSoftLabel(0, MyCanvas.soft_label[0]);
                        this.setSoftLabel(1, MyCanvas.soft_label[1]);
                        break;
                    }
                    break;
                }
            }
            if (MyCanvas.wnd_param[6][1] != 0) {
                this.keyWnd();
            }
            this.myPaint();
            this.play(-4);
            if (MyCanvas.sivar[0] % 100 < 50) {
                if (this.fe[0] != 0) {
                    if (this.fe[0] == 1) {
                        final int[] fe = this.fe;
                        final int n336 = 1;
                        ++fe[n336];
                        if (this.fe[1] == this.fe[2]) {
                            MyCanvas.snd_data[4][0] = 100;
                            MyCanvas.snd_opt[1] = 2;
                            MyCanvas.snd_opt[2] = 0;
                            this.play(-2);
                            if (this.fe[3] != -1) {
                                this.play(this.fe[3]);
                            }
                            this.fe[0] = 0;
                            this.fe[1] = 0;
                            this.fe[2] = 0;
                            this.fe[3] = -1;
                        }
                        else {
                            MyCanvas.snd_data[4][0] = 100 * (this.fe[2] - this.fe[1]) / this.fe[2];
                        }
                        MyCanvas.audio[0].setAttribute(4, MyCanvas.snd_val[2] * MyCanvas.snd_data[4][0] / 100);
                    }
                }
                else {
                    this.fe[0] = 0;
                    this.fe[1] = 0;
                    this.fe[2] = 0;
                    this.fe[3] = -1;
                }
            }
            array2[0] = 2000 / MyCanvas.sivar[4] / MyCanvas.sivar[5];
            if (MyCanvas.slvar[0] == 0L) {
                MyCanvas.slvar[0] = System.currentTimeMillis();
            }
            else if ((System.currentTimeMillis() - MyCanvas.slvar[0]) / array2[0] > 5L) {
                MyCanvas.slvar[0] = System.currentTimeMillis() - array2[0] * 5;
            }
            array2[1] = (int)(MyCanvas.slvar[0] + array2[0] - System.currentTimeMillis());
            final long[] slvar = MyCanvas.slvar;
            final int n337 = 0;
            slvar[n337] += array2[0];
            if (array2[1] < 0) {
                array2[1] = 0;
            }
            else if (array2[1] > array2[0]) {
                array2[1] = array2[0];
            }
            try {
                Thread.sleep(array2[1]);
            }
            catch (final Exception ex8) {}
        }
    }
    
    public void paint(final Graphics graphics) {
    }
    
    public void myPaint() {
        final int[] array = new int[8];
        final int[] array2 = new int[8];
        final String[] array3 = new String[4];
        MyCanvas.g.lock();
        MyCanvas.g.setPictoColorEnabled(true);
        final Graphics g = MyCanvas.g;
        final Font[] font = MyCanvas.font;
        final int[] sivar = MyCanvas.sivar;
        final int n = 11;
        final int n2 = 1;
        sivar[n] = n2;
        g.setFont(font[n2]);
        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
        MyCanvas.sivar[12] = 0;
        if (MyCanvas.sivar[2] >= 100) {
            MyCanvas.g3d.setScreenScale(4096, 4096);
            MyCanvas.g3d.setPrimitiveTextureArray(MyCanvas.tex);
            MyCanvas.g3d.enableSemiTransparent(true);
            MyCanvas.g3d.enableLight(true);
            MyCanvas.g3d.setAmbientLight(0);
            MyCanvas.g3d.setDirectionLight(new Vector3D(0, 0, 4096), 4096);
            MyCanvas.trans.setIdentity();
            MyCanvas.g3d.setViewTrans(MyCanvas.trans);
            MyCanvas.g3d.setScreenCenter(0, 0);
        }
        switch (MyCanvas.sivar[2]) {
            case 100: {
                if (this.p_flg[0] >= 0 && this.p_flg[0] < 99) {
                    MyCanvas.g.drawImage(MyCanvas.img[229], 0, 0);
                    int n3 = this.t_ani1[this.t_ani1.length - 1];
                    if (this.p_flg[0] == 0) {
                        n3 = this.t_ani1[this.p_flg[1]];
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[230], 0, n3);
                    if (this.taiken_flg == 1) {
                        MyCanvas.g.drawImage(MyCanvas.img[23], 165, n3 + 107);
                    }
                    if (this.p_flg[0] >= 1 && this.p_flg[0] <= 5) {
                        int n4 = 33;
                        if (this.p_flg[0] == 1) {
                            n4 = 33 + this.t_ani2[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 3) {
                            n4 = 33 + this.t_ani3[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 4) {
                            n4 = 33 - this.t_ani2[this.p_flg[1]];
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[231], n4, 142);
                        if (this.p_flg[2] == 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[206], n4 - 1, 141, 0, this.p_flg[3] * 24, 176, 24);
                        }
                        else if (this.p_flg[2] == 1) {
                            MyCanvas.g.drawImage(MyCanvas.img[206], n4 - 1, 169, 0, this.p_flg[3] * 24, 176, 24);
                        }
                        else if (this.p_flg[2] == 2) {
                            MyCanvas.g.drawImage(MyCanvas.img[207], n4 - 1, 197, 0, this.p_flg[3] * 24, 86, 24);
                        }
                        else if (this.p_flg[2] == 3) {
                            MyCanvas.g.drawImage(MyCanvas.img[207], n4 - 1 + 90, 197, 0, this.p_flg[3] * 24, 86, 24);
                        }
                        if (this.p_flg[0] == 5) {
                            int n5 = 255 * this.p_flg[1] / 10;
                            if (n5 > 255) {
                                n5 = 255;
                            }
                            if (n5 != 0) {
                                this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                                MyCanvas.pri[0].getColorArray()[0] = (n5 << 16 | n5 << 8 | n5);
                                MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                                MyCanvas.g3d.flush();
                            }
                        }
                    }
                    if ((this.p_flg[0] >= 10 && this.p_flg[0] <= 14) || (this.p_flg[0] >= 30 && this.p_flg[0] <= 31)) {
                        int n6 = 33;
                        if (this.p_flg[0] == 10) {
                            n6 = 33 + this.t_ani2[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 12) {
                            n6 = 33 + this.t_ani3[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 13) {
                            n6 = 33 - this.t_ani3[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 14) {
                            n6 = 33 - this.t_ani2[this.p_flg[1]];
                        }
                        int n7;
                        if (this.p_flg[24] == 0) {
                            n7 = 170;
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 170, 0, 22, 174, 22);
                        }
                        else if (this.p_flg[24] == 1) {
                            n7 = 155;
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 155, 0, 0, 174, 22);
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 183, 0, 22, 174, 22);
                        }
                        else if (this.p_flg[24] == 2) {
                            n7 = 155;
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 155, 0, 22, 174, 22);
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 183, 0, 44, 174, 22);
                        }
                        else {
                            n7 = 142;
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 142, 0, 0, 174, 22);
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 170, 0, 22, 174, 22);
                            MyCanvas.g.drawImage(MyCanvas.img[232], n6, 198, 0, 44, 174, 22);
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[206], n6 - 1, n7 - 1 + this.p_flg[2] * 28, 0, this.p_flg[3] * 24, 176, 24);
                        if (this.p_flg[0] >= 30 && this.p_flg[0] <= 31) {
                            int n8 = 255 * this.p_flg[1] / 15;
                            if (n8 > 255) {
                                n8 = 255;
                            }
                            if (n8 != 0) {
                                this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                                MyCanvas.pri[0].getColorArray()[0] = (n8 << 16 | n8 << 8 | n8);
                                MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                                MyCanvas.g3d.flush();
                            }
                        }
                    }
                    if (this.p_flg[0] >= 20 && this.p_flg[0] <= 24) {
                        int n9 = 3;
                        if (this.p_flg[0] == 20) {
                            n9 = 3 + this.t_ani2[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 22) {
                            n9 = 3 - this.t_ani3[this.p_flg[1]];
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[233], n9, 117);
                        MyCanvas.g.drawImage(MyCanvas.img[234 + this.p_flg[2]], n9, 142);
                        final String string = this.save0[1] + "\u70b9";
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                        MyCanvas.sivar[12] = 6;
                        this.drawString(MyCanvas.g, string, n9 + 217, 173);
                        if (this.p_flg[26] % 2 == 0) {
                            String string2 = this.save0[2] + "\u4f4d";
                            if (this.save0[2] == 0) {
                                string2 = "----\u4f4d";
                            }
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 0, 148));
                            MyCanvas.sivar[12] = 6;
                            this.drawString(MyCanvas.g, string2, n9 + 228, 191);
                            String string3 = this.save0[3] + "\u4f4d";
                            if (this.save0[3] == 0) {
                                string3 = "----\u4f4d";
                            }
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 255, 255));
                            MyCanvas.sivar[12] = 6;
                            this.drawString(MyCanvas.g, string3, n9 + 152, 191);
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[207], n9 + 29 + this.p_flg[2] * 90, 207, 0, this.p_flg[3] * 24, 86, 24);
                        if (this.p_flg[0] < 23) {
                            break;
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 159, 214));
                        int n10 = 120;
                        if (this.p_flg[0] == 23) {
                            n10 = this.kiri_tbl3[this.p_flg[1]];
                        }
                        MyCanvas.g.fillRect(120 - n10, 0, n10 * 2, 240);
                        if (this.p_flg[0] == 24) {
                            if (this.p_flg[1] == 1) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], -23, 24, 90, 92, 0, 0, 45, 46);
                            }
                            else if (this.p_flg[1] == 2 || this.p_flg[1] >= 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 9, 57, 0, 0, 45, 46);
                            }
                            else if (this.p_flg[1] == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 9, 56, 0, 0, 45, 46);
                            }
                            if (this.p_flg[1] == 3) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 29, 24, 88, 92, 45, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 4 || this.p_flg[1] >= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 56, 57, 45, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 56, 56, 45, 0, 44, 46);
                            }
                            if (this.p_flg[1] == 5) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 81, 24, 88, 92, 89, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 6 || this.p_flg[1] >= 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 103, 57, 89, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 103, 56, 89, 0, 44, 46);
                            }
                            if (this.p_flg[1] == 7) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 133, 24, 92, 92, 133, 0, 46, 46);
                            }
                            else if (this.p_flg[1] == 8 || this.p_flg[1] >= 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 151, 57, 133, 0, 46, 46);
                            }
                            else if (this.p_flg[1] == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 151, 56, 133, 0, 46, 46);
                            }
                            if (this.p_flg[1] == 9) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 194, 24, 66, 92, 179, 0, 33, 46);
                            }
                            else if (this.p_flg[1] == 10 || this.p_flg[1] >= 12) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 200, 57, 179, 0, 33, 46);
                            }
                            else if (this.p_flg[1] == 11) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 200, 56, 179, 0, 33, 46);
                            }
                            int n11 = this.p_flg[1];
                            if (n11 > 12) {
                                n11 = 12;
                            }
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0 + 255 * n11 / 12, 159 + 96 * n11 / 12, 214 + 41 * n11 / 12));
                            MyCanvas.sivar[12] = 10;
                            this.drawString(MyCanvas.g, "Now Loading...", 239, 239);
                        }
                        if (this.p_flg[4] != 0) {
                            int n12 = 0;
                            if (this.p_flg[4] == 1) {
                                n12 = this.n_tbl1[this.p_flg[5]];
                            }
                            else if (this.p_flg[4] == 2) {
                                n12 = this.n_tbl2[this.p_flg[5]];
                            }
                            else if (this.p_flg[4] == 3) {
                                n12 = 161;
                                if (this.p_flg[5] == 1 || this.p_flg[5] == 3 || this.p_flg[5] == 5 || this.p_flg[5] == 7 || this.p_flg[5] == 9) {
                                    n12 = 157;
                                }
                            }
                            MyCanvas.g.drawImage(MyCanvas.img[208], -15, n12);
                            break;
                        }
                        break;
                    }
                    else {
                        if (this.p_flg[0] < 50 || this.p_flg[0] > 51) {
                            break;
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[54], 0, 0);
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(140, 140, 140));
                        MyCanvas.g.fillRect(0, 25, 240, 129);
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(158, 158, 158));
                        for (int n13 = 0; 10 + n13 * 10 < 240; ++n13) {
                            MyCanvas.g.fillRect(10 + n13 * 10, 25, 1, 129);
                        }
                        for (int n14 = 0; 31 + n14 * 10 < 154; ++n14) {
                            MyCanvas.g.fillRect(0, 31 + n14 * 10, 240, 1);
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(120, 120, 120));
                        MyCanvas.g.fillRect(0, 154, 240, 86);
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                        MyCanvas.g.fillRect(1, 155, 238, 84);
                        MyCanvas.g.fillRect(0, 153, 240, 1);
                        for (int i = 0; i < this.zukan1.length; ++i) {
                            if (i == this.p_flg[2]) {
                                MyCanvas.g.drawImage(MyCanvas.img[52], 5 + i * 11, 27, 9, 0, 9, 9);
                            }
                            else {
                                MyCanvas.g.drawImage(MyCanvas.img[52], 5 + i * 11, 27, 0, 0, 9, 9);
                            }
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        if (this.save0[4 + this.uni[1][0][0] - 2] != 0) {
                            for (int j = 0; j < 5; ++j) {
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, this.zukan3[this.uni[1][0][0] - 2][j], 7, 162 + j * 15);
                            }
                        }
                        else {
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u3010\uff1f\uff1f\uff1f\u3011", 7, 162);
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u307e\u3060\u51fa\u73fe\u3057\u3066\u3044\u307e\u305b\u3093\u3002", 7, 177);
                        }
                        final int n15 = this.ta3[this.p_flg[17] % this.ta3.length];
                        MyCanvas.g.drawImage(MyCanvas.img[56], 4 + n15, 118);
                        MyCanvas.g.drawImage(MyCanvas.img[55], 225 - n15, 118);
                        if (this.save0[4 + this.uni[1][0][0] - 2] != 0) {
                            this.teki_b(MyCanvas.g, this.uni[1][0][0], this.zukan2[this.uni[1][0][0] - 2], 147, this.uni[1][0][1], this.uni[1][0][2]);
                        }
                        else {
                            MyCanvas.g.drawImage(MyCanvas.img[57], 102, 144, 0, 73, 36, 3);
                            MyCanvas.g.drawImage(MyCanvas.img[57], 102, 71 - this.zukan4[this.p_flg[17] % this.zukan4.length], 0, 0, 36, 73);
                        }
                        if (this.p_flg[0] != 51) {
                            break;
                        }
                        int n16 = 255 * this.p_flg[1] / 10;
                        if (n16 > 255) {
                            n16 = 255;
                        }
                        if (n16 != 0) {
                            this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                            MyCanvas.pri[0].getColorArray()[0] = (n16 << 16 | n16 << 8 | n16);
                            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                            MyCanvas.g3d.flush();
                            break;
                        }
                        break;
                    }
                }
                else {
                    if (this.p_flg[0] < 100) {
                        break;
                    }
                    if (this.p_flg[0] >= 110 && this.p_flg[0] <= 153) {
                        MyCanvas.g.drawImage(MyCanvas.img[217], 0, 25);
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 171, 227));
                        final int n17 = this.p_flg[7] % 10;
                        final int n18 = this.p_flg[8] % 10;
                        int n19 = 0;
                        while (true) {
                            MyCanvas.g.fillRect(n17 + n19 * 10, 0, 1, 240);
                            MyCanvas.g.fillRect(0, n18 + n19 * 10, 240, 1);
                            if (n17 + n19 * 10 >= 240 && n18 + n19 * 10 >= 240) {
                                break;
                            }
                            ++n19;
                        }
                        if (this.p_flg[9] + 251 < 240 && this.p_flg[9] + 251 + 99 > 0 && this.p_flg[10] + 0 < 240 && this.p_flg[10] + 0 + 148 > 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[212], this.p_flg[9] + 251, this.p_flg[10] + 0, 0, 95, 99, 148);
                        }
                        if (this.p_flg[9] + 96 < 240 && this.p_flg[9] + 96 + 190 > 0 && this.p_flg[10] + 148 < 240 && this.p_flg[10] + 148 + 95 > 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[212], this.p_flg[9] + 96, this.p_flg[10] + 148, 0, 0, 190, 95);
                        }
                        if (this.p_flg[9] + 96 < 240 && this.p_flg[9] + 96 + 76 > 0 && this.p_flg[10] + 243 < 240 && this.p_flg[10] + 243 + 44 > 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[212], this.p_flg[9] + 96, this.p_flg[10] + 243, 99, 95, 76, 44);
                        }
                        if (this.p_flg[9] + 69 < 240 && this.p_flg[9] + 69 + 39 > 0 && this.p_flg[10] + 330 < 240 && this.p_flg[10] + 330 + 43 > 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[212], this.p_flg[9] + 69, this.p_flg[10] + 330, 99, 139, 39, 43);
                        }
                        if (this.p_flg[9] + 0 < 240 && this.p_flg[9] + 0 + 7 > 0 && this.p_flg[10] + 407 < 240 && this.p_flg[10] + 407 + 6 > 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[212], this.p_flg[9] + 0, this.p_flg[10] + 407, 99, 182, 7, 6);
                        }
                        int n20 = 0;
                        if (this.p_flg[0] != 150) {
                            n20 = 1;
                        }
                        else if (this.p_flg[1] != 0 && this.p_flg[1] != 2 && this.p_flg[1] != 4) {
                            n20 = 1;
                        }
                        if (n20 == 1) {
                            final int n21 = this.p_flg[16] * 6;
                            if (this.p_flg[9] + this.tizu1[n21 + 4] < 240 && this.p_flg[9] + this.tizu1[n21 + 4] + this.tizu1[n21 + 2] > 0 && this.p_flg[10] + this.tizu1[n21 + 5] < 240 && this.p_flg[10] + this.tizu1[n21 + 5] + this.tizu1[n21 + 3] > 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[213], this.p_flg[9] + this.tizu1[n21 + 4], this.p_flg[10] + this.tizu1[n21 + 5], this.tizu1[n21 + 0], this.tizu1[n21 + 1], this.tizu1[n21 + 2], this.tizu1[n21 + 3]);
                            }
                        }
                        if (this.p_flg[0] <= 140) {
                            MyCanvas.g.drawImage(MyCanvas.img[214], 28, 26);
                        }
                    }
                    if (this.p_flg[0] >= 200 && this.p_flg[0] <= 250) {
                        MyCanvas.g.drawImage(MyCanvas.img[220], 0, 25);
                        for (int k = 0; k < 9; ++k) {
                            if (this.save3[1] >= this.shop2[k]) {
                                final int n22 = (k + 1) % 5 * 48 + 1;
                                final int n23 = (k + 1) / 5 * 39 + 27;
                                if (this.save3[k + 13] != 0) {
                                    if (this.save3[k + 13] == 10) {
                                        MyCanvas.g.drawImage(MyCanvas.img[224], n22, n23, (k + 1) % 5 * 46, 74 + (k + 1) / 5 * 37, 46, 37);
                                    }
                                    else {
                                        MyCanvas.g.drawImage(MyCanvas.img[224], n22, n23, (k + 1) % 5 * 46, (k + 1) / 5 * 37, 46, 37);
                                    }
                                    int l = this.save3[k + 13];
                                    int n24 = 0;
                                    do {
                                        MyCanvas.g.drawImage(MyCanvas.img[225], n22 + 38 - n24, n23 + 1, l % 10 * 6, 0, 6, 9);
                                        l /= 10;
                                        n24 += 5;
                                    } while (l != 0);
                                }
                                else {
                                    MyCanvas.g.drawImage(MyCanvas.img[216 + this.p_flg[3] * 38], n22 + 27, n23 + 2);
                                }
                            }
                        }
                        for (int n25 = 0; n25 < 9; ++n25) {
                            if (this.save3[n25 + 2] == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[13], n25 % 5 * 48 + 1, n25 / 5 * 39 + 105, n25 % 5 * 46, n25 / 5 * 37, 46, 37);
                            }
                            int n26 = this.save3[n25 + 2] + 1;
                            int n27 = n25 % 5 * 48 + 1 + 38;
                            final int n28 = n25 / 5 * 39 + 105 + 1;
                            do {
                                MyCanvas.g.drawImage(MyCanvas.img[225], n27, n28, n26 % 10 * 6, 0, 6, 9);
                                n26 /= 10;
                                n27 -= 5;
                            } while (n26 != 0);
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        if (this.p_flg[2] >= 1 && this.p_flg[2] <= 9) {
                            String s;
                            if (this.save3[1] < this.shop2[this.p_flg[2] - 1]) {
                                s = "\uff1f\uff1f\uff1f";
                            }
                            else if (this.save3[13 + this.p_flg[2] - 1] < 10) {
                                s = this.shop4[this.p_flg[2] - 1];
                            }
                            else {
                                s = this.shop4[this.p_flg[2] - 1 + 9];
                            }
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, s, 6, 191);
                        }
                        else if (this.p_flg[2] >= 10 && this.p_flg[2] <= 18) {
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, this.shop3[(this.p_flg[2] - 10) * 3], 6, 191);
                        }
                        if (this.p_flg[2] >= 1 && this.p_flg[2] <= 9) {
                            if (this.save3[13 + this.p_flg[2] - 1] > 0 && this.save3[13 + this.p_flg[2] - 1] != 10) {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                                MyCanvas.sivar[12] = 5;
                                final int m = this.save3[13 + this.p_flg[2] - 1];
                                this.drawString(MyCanvas.g, "LV" + m + "\u3000LV" + (m + 1), 120, 191);
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(244, 0, 217));
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, "   \u21d2", 120, 191);
                            }
                        }
                        else if (this.p_flg[2] >= 10 && this.p_flg[2] <= 18 && this.save3[this.p_flg[2] - 10 + 2] != 9) {
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 5;
                            final int i2 = this.save3[this.p_flg[2] - 10 + 2] + 1;
                            this.drawString(MyCanvas.g, "LV" + i2 + "\u3000LV" + (i2 + 1), 120, 191);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(244, 0, 217));
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "   \u21d2", 120, 191);
                        }
                        int n29;
                        if (this.p_flg[2] < 10) {
                            if (this.save3[1] < this.shop2[this.p_flg[2] - 1]) {
                                n29 = -2;
                            }
                            else if (this.save3[this.p_flg[2] - 1 + 13] == 10) {
                                n29 = -1;
                            }
                            else {
                                n29 = this.shop1[this.p_flg[2] - 1 + 11][this.save3[this.p_flg[2] - 1 + 13]];
                            }
                        }
                        else if (this.save3[this.p_flg[2] - 10 + 2] == 9) {
                            n29 = -1;
                        }
                        else {
                            n29 = this.shop1[this.p_flg[2] - 10][this.save3[this.p_flg[2] - 10 + 2]];
                        }
                        if (n29 == -1) {
                            MyCanvas.g.drawImage(MyCanvas.img[223], 190, 185);
                        }
                        else if (n29 != -2) {
                            int n30 = 224;
                            do {
                                MyCanvas.g.drawImage(MyCanvas.img[261], n30, 185, n29 % 10 * 13, 0, 13, 19);
                                n29 /= 10;
                                n30 -= 11;
                            } while (n29 > 0);
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        if (this.c_dai[0] == 0) {
                            if (this.p_flg[2] >= 1 && this.p_flg[2] <= 9) {
                                final int n31 = this.p_flg[2] - 1;
                                int n32 = 3;
                                if (this.save3[1] < this.shop2[n31]) {
                                    n32 = 0;
                                }
                                else if (this.save3[13 + n31] == 0) {
                                    n32 = 1;
                                }
                                else if (this.save3[13 + n31] < 10) {
                                    n32 = 2;
                                }
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, this.shop5[n32 * 18 + n31 * 2], 7, 210);
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, this.shop5[n32 * 18 + n31 * 2 + 1], 7, 224);
                            }
                            else if (this.p_flg[2] >= 10 && this.p_flg[2] <= 18) {
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, this.shop3[(this.p_flg[2] - 10) * 3 + 1], 7, 210);
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, this.shop3[(this.p_flg[2] - 10) * 3 + 2], 7, 224);
                            }
                        }
                        else {
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, this.c_moji[this.c_dai[0]], 7, 210);
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[222], 0 + this.p_flg[2] % 5 * 48, 26 + this.p_flg[2] / 5 * 39, 0, this.p_flg[3] * 39, 48, 39);
                        if (this.p_flg[20] != 0) {
                            final int n33 = 255 * this.p_flg[20] / 4;
                            this.setQuad2(MyCanvas.pri[0], 0, this.p_flg[21] % 5 * 48 + 1, this.p_flg[21] / 5 * 39 + 27, 1000, 46, 37);
                            MyCanvas.pri[0].getColorArray()[0] = (n33 << 16 | n33 << 8 | n33);
                            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 64);
                            MyCanvas.g3d.flush();
                        }
                        if (this.p_flg[27] == 2) {
                            this.box(MyCanvas.g, 20, 70, 200, 99);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u3059\u3079\u3066\u306e\u30e6\u30cb\u30c3\u30c8\u306e\u7372\u5f97", 120, 76);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u304a\u3081\u3067\u3068\u3046\u306b\u3083\uff01\uff01", 120, 91);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u5404\u30e6\u30cb\u30c3\u30c8\u306f\u300cLV10\u300d\u306b\u306a\u308b\u3068", 120, 121);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u30af\u30e9\u30b9\u30c1\u30a7\u30f3\u30b8\u3057\u3066", 120, 136);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u771f\u306e\u59ff\u3078\u3068\u5909\u8c8c\u3059\u308b\u306e\u306b\u3083\u266a", 120, 151);
                        }
                    }
                    if (this.p_flg[0] >= 300 && this.p_flg[0] <= 350) {
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                        MyCanvas.g.fillRect(0, 25, 240, 183);
                        MyCanvas.g.drawImage(MyCanvas.img[236], 0, 208);
                        if (this.p_flg3[this.p_flg[18]] != 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[241 + this.p_flg[18]], 40, 31, 0, 0, 160, 90);
                            final String str = this.ta6[this.p_flg[18] * 3];
                            final String string4 = this.p_flg3[this.p_flg[18]] + "%\u767a\u52d5";
                            final int stringWidth = MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str);
                            final int n34 = (240 - MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str + string4)) / 2;
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, str, n34, 35);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, string4, stringWidth + n34, 35);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, this.ta6[this.p_flg[18] * 3 + 1], 120, 93);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, this.ta6[this.p_flg[18] * 3 + 2], 120, 107);
                        }
                        else {
                            MyCanvas.g.drawImage(MyCanvas.img[241 + this.p_flg[18]], 40, 31, 0, 90, 160, 90);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\uff1f\uff1f\uff1f", 120, 35);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u767a\u52d5\u306b\u5fc5\u8981\u306a\u304a\u5b9d\u304c", 120, 93);
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, "\u96c6\u307e\u3063\u3066\u3044\u307e\u305b\u3093", 120, 107);
                        }
                        for (int n35 = 0; n35 < this.ta1[this.p_flg[18]]; ++n35) {
                            MyCanvas.g.drawImage(MyCanvas.img[237], 21 + n35 % 4 * 51, 137 + n35 / 4 * 36, 0, (3 - this.save6[this.ta2[this.p_flg[18]][n35]]) * 30, 45, 30);
                        }
                        int n36 = 0;
                        int n37 = 0;
                        if (this.p_flg[19] == 0) {
                            n36 = this.ta3[this.p_flg[17] % this.ta3.length];
                            n37 = this.p_flg[17] % 2;
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[238], 4 + n36, 66, n37 * 11, 0, 11, 21);
                        MyCanvas.g.drawImage(MyCanvas.img[238], 225 - n36, 66, n37 * 11, 21, 11, 21);
                        if (this.p_flg[19] == 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[240], 108, 126, 0, 0, 24, 7);
                        }
                        else {
                            MyCanvas.g.drawImage(MyCanvas.img[240], 108, 126, 0, 7, 24, 7);
                            MyCanvas.g.drawImage(MyCanvas.img[239], 20 + this.p_flg[2] % 4 * 51, 136 + this.p_flg[2] / 4 * 36, 0, this.p_flg[3] * 32, 47, 32);
                            final int n38 = this.save6[this.ta2[this.p_flg[18]][this.p_flg[2]]];
                            if (n38 == 0) {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                                MyCanvas.sivar[12] = 4;
                                this.drawString(MyCanvas.g, "\u304a\u5b9d \u3000\u3000\u3000", 120, 210);
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                                MyCanvas.sivar[12] = 4;
                                this.drawString(MyCanvas.g, "\u3000\u3000 \uff1f\uff1f\uff1f", 120, 210);
                            }
                            else {
                                final String str2 = "\u304a\u5b9d ";
                                final String string5 = this.ta5[n38 - 1] + this.ta4[this.ta2[this.p_flg[18]][this.p_flg[2]]];
                                final int stringWidth2 = MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str2);
                                final int n39 = (240 - MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str2 + string5)) / 2;
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, str2, n39, 210);
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                                MyCanvas.sivar[12] = 5;
                                this.drawString(MyCanvas.g, string5, stringWidth2 + n39, 210);
                                MyCanvas.sivar[12] = 4;
                                this.drawString(MyCanvas.g, this.tizu2[this.ta2[this.p_flg[18]][this.p_flg[2]]] + "\u3067\u30b2\u30c3\u30c8\uff01", 120, 224);
                            }
                        }
                    }
                    if ((this.p_flg[0] >= 100 && this.p_flg[0] <= 115) || this.p_flg[0] == 200 || this.p_flg[0] == 240 || this.p_flg[0] == 300 || this.p_flg[0] == 340) {
                        int n40 = 0;
                        if (this.p_flg[0] != 100) {
                            n40 = this.fusuma1[this.p_flg[1]];
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[200], 0 - n40, 25);
                        MyCanvas.g.drawImage(MyCanvas.img[201], 120 + n40, 25);
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[199], 0, 0);
                    int n41 = this.p_flg[22];
                    if (n41 > 9999999) {
                        n41 = 9999999;
                    }
                    int n42 = 223;
                    do {
                        MyCanvas.g.drawImage(MyCanvas.img[261], n42, 2, n41 % 10 * 13, 0, 13, 19);
                        n41 /= 10;
                        n42 -= 11;
                    } while (n41 > 0);
                    if (this.p_flg[0] == 100) {
                        MyCanvas.g.drawImage(MyCanvas.img[210], 0, 0);
                    }
                    else if (this.p_flg[0] == 110 || this.p_flg[0] == 115 || this.p_flg[0] == 200 || this.p_flg[0] == 240 || this.p_flg[0] == 300 || this.p_flg[0] == 340) {
                        MyCanvas.g.drawImage(MyCanvas.img[210], 0 - this.fusuma1[this.p_flg[1]], 0);
                    }
                    else if (this.p_flg[0] == 120 || this.p_flg[0] == 140) {
                        MyCanvas.g.drawImage(MyCanvas.img[211], 0 - this.fusuma2[this.p_flg[1]], 0);
                    }
                    else if (this.p_flg[0] == 130 || (this.p_flg[0] >= 150 && this.p_flg[0] <= 153)) {
                        MyCanvas.g.drawImage(MyCanvas.img[211], 0, 0);
                    }
                    else if (this.p_flg[0] == 210 || this.p_flg[0] == 230) {
                        MyCanvas.g.drawImage(MyCanvas.img[221], 0 - this.fusuma2[this.p_flg[1]], 0);
                    }
                    else if (this.p_flg[0] == 220) {
                        MyCanvas.g.drawImage(MyCanvas.img[221], 0, 0);
                    }
                    else if (this.p_flg[0] == 310 || this.p_flg[0] == 330) {
                        MyCanvas.g.drawImage(MyCanvas.img[226], 0 - this.fusuma2[this.p_flg[1]], 0);
                    }
                    else if (this.p_flg[0] == 320) {
                        MyCanvas.g.drawImage(MyCanvas.img[226], 0, 0);
                    }
                    if (this.p_flg[0] == 100) {
                        MyCanvas.g.drawImage(MyCanvas.img[203], 33, 61);
                        MyCanvas.g.drawImage(MyCanvas.img[202], 33, 89);
                        MyCanvas.g.drawImage(MyCanvas.img[204], 33, 131);
                        MyCanvas.g.drawImage(MyCanvas.img[205], 123, 131);
                        if (this.p_flg[2] == 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[206], 32, 60, 0, this.p_flg[3] * 24, 176, 24);
                        }
                        else if (this.p_flg[2] == 1) {
                            MyCanvas.g.drawImage(MyCanvas.img[206], 32, 88, 0, this.p_flg[3] * 24, 176, 24);
                        }
                        else if (this.p_flg[2] == 2) {
                            MyCanvas.g.drawImage(MyCanvas.img[207], 32, 130, 0, this.p_flg[3] * 24, 86, 24);
                        }
                        else if (this.p_flg[2] == 3) {
                            MyCanvas.g.drawImage(MyCanvas.img[207], 122, 130, 0, this.p_flg[3] * 24, 86, 24);
                        }
                    }
                    if (this.p_flg[0] >= 120 && this.p_flg[0] <= 150) {
                        int n43 = 0;
                        if (this.p_flg[0] == 120 || this.p_flg[0] == 140) {
                            n43 = this.fusuma3[this.p_flg[1]];
                        }
                        else if (this.p_flg[0] == 150) {
                            n43 = this.men1[this.p_flg[1]];
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[215], 152, 118 + n43);
                        final int n44 = this.p_flg[2] % 6;
                        final int n45 = this.p_flg[2] / 6;
                        final int n46 = n45 * 6;
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                        for (int n47 = 0; n47 < 6 && n46 + n47 <= this.save3[1] && n46 + n47 <= 47; ++n47) {
                            int n48;
                            for (n48 = 0; this.tizu3[n48] != n46 + n47; ++n48) {}
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, this.tizu2[n48], 183, 139 + n47 * 16 + n43);
                            if (n46 + n47 == this.save3[1]) {
                                MyCanvas.g.drawImage(MyCanvas.img[216], 160, 143 + n47 * 16 + n43);
                            }
                            if (this.save0[0] == 1 && this.save6[n48] != 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[260], 164, 139 + n47 * 16 + n43, 0, (this.save6[n48] - 1) * 13, 13, 13);
                            }
                        }
                        MyCanvas.g.drawImage(MyCanvas.img[218], 155, 135 + n44 * 16 + n43, 0, this.p_flg[3] * 19, 79, 19);
                        if (this.save3[1] / 6 != 0) {
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            final String string6 = n45 + 1 + "/" + ((this.save3[1] > 47) ? 8 : (this.save3[1] / 6 + 1));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, string6, 195, 120 + n43);
                            if (this.p_flg[17] % 6 >= 3) {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(128, 128, 128));
                            }
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u2190", 160, 120 + n43);
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u2192", 217, 120 + n43);
                        }
                        if (118 + n43 < 240 && this.save4[this.p_flg[2]] != 0) {
                            final String string7 = "\u30af\u30ea\u30a2\u6570 " + this.save4[this.p_flg[2]] + "\u56de";
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 107, 144));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, string7, 196, 104 + n43 + 1);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, string7, 195, 104 + n43);
                        }
                    }
                    if (this.p_flg[0] == 151 || this.p_flg[0] == 152) {
                        int n49 = 0;
                        if (this.p_flg[0] == 151) {
                            n49 = this.men3[this.p_flg[1]];
                        }
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        MyCanvas.g.fillRect(0 - n49, 121, 240, 1);
                        MyCanvas.sivar[12] = 5;
                        this.drawString(MyCanvas.g, this.tizu2[this.p_flg[16]], 3 - n49, 124);
                        MyCanvas.g.fillRect(0 + n49, 193, 240, 1);
                        if (this.p_flg[0] == 152) {
                            if (this.p_flg[1] == 1) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], -23, 24, 90, 92, 0, 0, 45, 46);
                            }
                            else if (this.p_flg[1] == 2 || this.p_flg[1] >= 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 9, 57, 0, 0, 45, 46);
                            }
                            else if (this.p_flg[1] == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 9, 56, 0, 0, 45, 46);
                            }
                            if (this.p_flg[1] == 3) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 29, 24, 88, 92, 45, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 4 || this.p_flg[1] >= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 56, 57, 45, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 56, 56, 45, 0, 44, 46);
                            }
                            if (this.p_flg[1] == 5) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 81, 24, 88, 92, 89, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 6 || this.p_flg[1] >= 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 103, 57, 89, 0, 44, 46);
                            }
                            else if (this.p_flg[1] == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 103, 56, 89, 0, 44, 46);
                            }
                            if (this.p_flg[1] == 7) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 133, 24, 92, 92, 133, 0, 46, 46);
                            }
                            else if (this.p_flg[1] == 8 || this.p_flg[1] >= 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 151, 57, 133, 0, 46, 46);
                            }
                            else if (this.p_flg[1] == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 151, 56, 133, 0, 46, 46);
                            }
                            if (this.p_flg[1] == 9) {
                                MyCanvas.g.drawScaledImage(MyCanvas.img[219], 194, 24, 66, 92, 179, 0, 33, 46);
                            }
                            else if (this.p_flg[1] == 10 || this.p_flg[1] >= 12) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 200, 57, 179, 0, 33, 46);
                            }
                            else if (this.p_flg[1] == 11) {
                                MyCanvas.g.drawImage(MyCanvas.img[219], 200, 56, 179, 0, 33, 46);
                            }
                            int n50 = this.p_flg[1];
                            if (n50 > 12) {
                                n50 = 12;
                            }
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0 + 255 * n50 / 12, 132 + 123 * n50 / 12, 176 + 79 * n50 / 12));
                            MyCanvas.sivar[12] = 10;
                            this.drawString(MyCanvas.g, "Now Loading...", 239, 239);
                        }
                    }
                    if (this.p_flg[4] == 0) {
                        break;
                    }
                    int n51 = 0;
                    if (this.p_flg[4] == 1 || this.p_flg[4] == 4) {
                        n51 = this.n_tbl1[this.p_flg[5]];
                    }
                    else if (this.p_flg[4] == 2) {
                        n51 = this.n_tbl2[this.p_flg[5]];
                    }
                    else if (this.p_flg[4] == 3) {
                        n51 = 161;
                        if (this.p_flg[5] == 1 || this.p_flg[5] == 3 || this.p_flg[5] == 5 || this.p_flg[5] == 7 || this.p_flg[5] == 9) {
                            n51 = 157;
                        }
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[208], -15, n51);
                    if (this.p_flg[4] == 2 && (this.p_flg[6] == 1 || this.p_flg[6] == 4)) {
                        MyCanvas.g.drawImage(MyCanvas.img[209], 21, n51 + 30);
                    }
                    if (this.p_flg[4] != 2 || this.p_flg[0] != 100) {
                        break;
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[252], 68, 160);
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    if (this.p_flg[2] == 0) {
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u3053\u3053\u304b\u3089\u95d8\u3044\u306b\u51fa\u767a\u306b\u3083\uff01", 156, 170);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u30af\u30ea\u30a2\u56de\u6570\u304c\u5897\u3048\u308b\u3068", 156, 190);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u3082\u3089\u3048\u308b\u7d4c\u9a13\u5024\u304c", 156, 204);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u6e1b\u3063\u3061\u3083\u3046\u306b\u3083\u266a", 156, 218);
                        break;
                    }
                    if (this.p_flg[2] == 1) {
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u6226\u95d8\u3067\u96c6\u3081\u305f\u7d4c\u9a13\u5024\u3067", 156, 175);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u306b\u3083\u3093\u3053\u8ecd\u56e3\u3092", 156, 193);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u30d1\u30ef\u30fc\u30a2\u30c3\u30d7\u53ef\u80fd\u306b\u3083\uff01", 156, 211);
                        break;
                    }
                    if (this.p_flg[2] == 2) {
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u5404\u5730\u306b\u7720\u308b\u304a\u5b9d\u3092\u96c6\u3081\u3066", 156, 170);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u7279\u6b8a\u80fd\u529b\u767a\u52d5\u306b\u3083\uff01", 156, 186);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u8cea\u306e\u9ad8\u3044\u304a\u5b9d\u307b\u3069", 156, 202);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u52b9\u679c\u306f\u7d76\u5927\u306b\u3083\u266a", 156, 218);
                        break;
                    }
                    if (this.p_flg[2] == 3) {
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u4eca\u307e\u3067\u306e\u30d7\u30ec\u30a4\u30c7\u30fc\u30bf\u3092", 156, 165);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u4fdd\u5b58\u3067\u304d\u308b\u306b\u3083\uff01", 156, 179);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u30bb\u30fc\u30d6\u305b\u305a\u306b\u7d42\u4e86\u3059\u308b\u3068", 156, 193);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u30c7\u30fc\u30bf\u304c\u6d88\u3048\u308b\u306e\u3067", 156, 207);
                        MyCanvas.sivar[12] = 4;
                        this.drawString(MyCanvas.g, "\u6ce8\u610f\u304c\u5fc5\u8981\u306b\u3083\uff01", 156, 221);
                        break;
                    }
                    break;
                }
            }
            case 400: {
                int n52 = this.kiri[0];
                if (n52 > this.kiri_tbl1.length - 1) {
                    n52 = this.kiri_tbl1.length - 1;
                }
                final int n53 = this.kiri_tbl1[n52];
                MyCanvas.g.drawImage(MyCanvas.img[227], n53, 0);
                if (n53 + 41 < 240) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                    MyCanvas.g.fillRect(n53 + 41, 0, 240 - (n53 + 41), 240);
                    break;
                }
                break;
            }
            case 402: {
                int n54 = this.kiri[0];
                if (n54 > this.kiri_tbl1.length - 1) {
                    n54 = this.kiri_tbl1.length - 1;
                }
                final int n55 = this.kiri_tbl1[n54];
                MyCanvas.g.drawImage(MyCanvas.img[227], n55, 0);
                if (n55 + 41 >= 240) {
                    break;
                }
                MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                MyCanvas.g.fillRect(n55 + 41, 0, 240 - (n55 + 41), 240);
                if (n55 + 41 <= 0) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(180, 180, 180));
                    MyCanvas.sivar[12] = 10;
                    this.drawString(MyCanvas.g, "Now Loading...", 239, 239);
                    break;
                }
                break;
            }
            case 300:
            case 401: {
                final int n56 = 240 - this.p_flg[5] / 10 % 240 - 240;
                MyCanvas.g.drawImage(MyCanvas.img[0 + this.dat[4]], n56, 0);
                MyCanvas.g.drawImage(MyCanvas.img[0 + this.dat[4]], n56 + 240, 0);
                if (this.dat[4] == 2) {
                    for (int n57 = 0; n57 < this.hosi.length; ++n57) {
                        int n58 = this.hosi[n57][2];
                        if (n58 > 100) {
                            n58 = 100 - (n58 - 100);
                        }
                        final int n59 = 110 * n58 / 100 + 130;
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(n59, n59, 80 * n58 / 100 + 160));
                        MyCanvas.g.fillRect((this.hosi[n57][0] - this.p_flg[5] / 10 % 240 + 240) % 240, this.hosi[n57][1], 1, 1);
                    }
                }
                int n60 = 0;
                this.z_tbl[n60][0] = 0;
                this.z_tbl[n60][1] = 0;
                this.z_tbl[n60][2] = 0;
                ++n60;
                this.z_tbl[n60][0] = 0;
                this.z_tbl[n60][1] = 1;
                this.z_tbl[n60][2] = 0;
                ++n60;
                for (int n61 = 1; n61 < this.uni[1].length; ++n61) {
                    if (this.uni[1][n61][0] > 0) {
                        this.z_tbl[n60][0] = this.uni[1][n61][5] + 1;
                        this.z_tbl[n60][1] = this.uni[1][n61][0] - 2 + 10;
                        if (this.uni[1][n61][1] == 4) {
                            this.z_tbl[n60][1] = 2;
                        }
                        this.z_tbl[n60][2] = n61;
                        ++n60;
                    }
                }
                for (int n62 = 1; n62 < this.uni[0].length; ++n62) {
                    if (this.uni[0][n62][0] > 0) {
                        this.z_tbl[n60][0] = this.uni[0][n62][5] + 1;
                        this.z_tbl[n60][1] = this.uni[0][n62][0] - 2 + 100;
                        if (this.uni[0][n62][6] >= 9) {
                            final int[] array4 = this.z_tbl[n60];
                            final int n63 = 1;
                            array4[n63] += 10;
                        }
                        if (this.uni[0][n62][1] == 4) {
                            this.z_tbl[n60][1] = 3;
                        }
                        this.z_tbl[n60][2] = n62;
                        ++n60;
                    }
                }
                for (int n64 = 0; n64 < n60 - 1; ++n64) {
                    int n65 = this.z_tbl[n64][0];
                    int n66 = n64;
                    for (int n67 = n64 + 1; n67 < n60; ++n67) {
                        if (this.z_tbl[n67][0] < n65) {
                            n65 = this.z_tbl[n67][0];
                            n66 = n67;
                        }
                    }
                    this.z_tbl[200][0] = this.z_tbl[n64][0];
                    this.z_tbl[200][1] = this.z_tbl[n64][1];
                    this.z_tbl[200][2] = this.z_tbl[n64][2];
                    this.z_tbl[n64][0] = this.z_tbl[n66][0];
                    this.z_tbl[n64][1] = this.z_tbl[n66][1];
                    this.z_tbl[n64][2] = this.z_tbl[n66][2];
                    this.z_tbl[n66][0] = this.z_tbl[200][0];
                    this.z_tbl[n66][1] = this.z_tbl[200][1];
                    this.z_tbl[n66][2] = this.z_tbl[200][2];
                }
                for (int n68 = 0; n68 < n60 - 1; ++n68) {
                    final int n69 = this.z_tbl[n68][0];
                    int n70 = n68;
                    int n71 = this.z_tbl[n68][2];
                    for (int n72 = n68 + 1; n72 < n60 && n69 == this.z_tbl[n72][0]; ++n72) {
                        if (this.z_tbl[n72][2] < n71) {
                            n71 = this.z_tbl[n72][2];
                            n70 = n72;
                        }
                    }
                    this.z_tbl[200][0] = this.z_tbl[n68][0];
                    this.z_tbl[200][1] = this.z_tbl[n68][1];
                    this.z_tbl[200][2] = this.z_tbl[n68][2];
                    this.z_tbl[n68][0] = this.z_tbl[n70][0];
                    this.z_tbl[n68][1] = this.z_tbl[n70][1];
                    this.z_tbl[n68][2] = this.z_tbl[n70][2];
                    this.z_tbl[n70][0] = this.z_tbl[200][0];
                    this.z_tbl[n70][1] = this.z_tbl[200][1];
                    this.z_tbl[n70][2] = this.z_tbl[200][2];
                }
                for (int n73 = 0; n73 < n60; ++n73) {
                    final int n74 = this.z_tbl[n73][2];
                    switch (this.z_tbl[n73][1]) {
                        case 0: {
                            final int n75 = (this.uni[1][0][3] - 600 - this.p_flg[5]) / 10;
                            if (n75 - 11 <= 240 && n75 + 71 >= 0) {
                                int n76 = 0;
                                if (this.uni[1][0][1] != 0) {
                                    n76 = this.p_flg[1] % 2;
                                }
                                MyCanvas.g.drawImage(MyCanvas.img[91 + this.p_flg[20]], n75 - n76 - 10, this.uni[1][0][4] / 10);
                                MyCanvas.g.drawImage(MyCanvas.img[31], n75 + 27, 53, 50, 0, 7, 7);
                                int n77 = this.uni[1][0][7];
                                if (n77 > 999999) {
                                    n77 = 999999;
                                }
                                int n78 = 100000;
                                int n79 = 0;
                                int n80 = 0;
                                while (true) {
                                    final int n81 = n77 / n78 % 10;
                                    n78 /= 10;
                                    if (n81 == 0 && n79 == 0 && n78 != 0) {
                                        continue;
                                    }
                                    n79 = 1;
                                    MyCanvas.g.drawImage(MyCanvas.img[31], n75 + 33 + n80, 53, n81 * 5, 0, 5, 7);
                                    n80 += 4;
                                    if (n78 == 0) {
                                        break;
                                    }
                                }
                                int n82 = this.uni[1][0][8];
                                int n83 = 0;
                                do {
                                    MyCanvas.g.drawImage(MyCanvas.img[31], n75 + 23 - n83, 53, n82 % 10 * 5, 0, 5, 7);
                                    n82 /= 10;
                                    n83 += 4;
                                } while (n82 != 0);
                                break;
                            }
                            break;
                        }
                        case 1: {
                            final int n84 = (this.uni[0][0][3] - this.p_flg[5]) / 10;
                            if (n84 - 1 <= 240 && n84 + 61 >= 0) {
                                int n85 = 0;
                                if (this.uni[0][0][1] != 0) {
                                    n85 = this.p_flg[1] % 2;
                                }
                                MyCanvas.g.drawImage(MyCanvas.img[90], n84 + n85, this.uni[0][0][4] / 10);
                                if (this.uni[0][0][9] == 1) {
                                    MyCanvas.g.drawImage(MyCanvas.img[197], n84 + n85, this.uni[0][0][4] / 10 + 28);
                                }
                                MyCanvas.g.drawImage(MyCanvas.img[31], n84 + 27, 53, 50, 0, 7, 7);
                                int n86 = this.uni[0][0][7];
                                if (n86 > 999999) {
                                    n86 = 999999;
                                }
                                int n87 = 100000;
                                int n88 = 0;
                                int n89 = 0;
                                while (true) {
                                    final int n90 = n86 / n87 % 10;
                                    n87 /= 10;
                                    if (n90 == 0 && n88 == 0 && n87 != 0) {
                                        continue;
                                    }
                                    n88 = 1;
                                    MyCanvas.g.drawImage(MyCanvas.img[31], n84 + 33 + n89, 53, n90 * 5, 0, 5, 7);
                                    n89 += 4;
                                    if (n87 == 0) {
                                        break;
                                    }
                                }
                                int n91 = this.uni[0][0][8];
                                int n92 = 0;
                                do {
                                    MyCanvas.g.drawImage(MyCanvas.img[31], n84 + 23 - n92, 53, n91 % 10 * 5, 0, 5, 7);
                                    n91 /= 10;
                                    n92 += 4;
                                } while (n91 != 0);
                                break;
                            }
                            break;
                        }
                        case 2: {
                            final int n93 = (this.uni[1][n74][3] - 340 - this.p_flg[5]) / 10;
                            if (n93 <= 240 && n93 + 34 >= 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[29], n93, this.uni[1][n74][4] / 10 + this.uni[1][n74][5] * 2 - 39, this.uni[1][n74][2] * 34, 0, 34, 39);
                                break;
                            }
                            break;
                        }
                        case 3: {
                            final int n94 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n94 <= 240 && n94 + 34 >= 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[29], n94, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 39, this.uni[0][n74][2] * 34, 0, 34, 39);
                                break;
                            }
                            break;
                        }
                        case 100: {
                            final int n95 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n95 <= 240 && n95 + 33 >= 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[32], n95, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 40, this.uni_pt1[0][this.uni[0][n74][1]][this.uni[0][n74][2]] * 33, 0, 33, 40);
                                break;
                            }
                            break;
                        }
                        case 101: {
                            final int n96 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n96 - 21 > 240 || n96 + 36 < 0) {
                                break;
                            }
                            final int n97 = this.uni_pt1[1][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n98 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n97 >= 0 && n97 <= 2) {
                                MyCanvas.g.drawImage(MyCanvas.img[33], n96, n98 - 61, n97 * 35, 0, 35, 61);
                                break;
                            }
                            if (n97 == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[33], n96 + 2, n98 - 69, 0, 62, 33, 69);
                                break;
                            }
                            if (n97 == 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[33], n96 + 2, n98 - 70, 33, 62, 34, 70);
                                break;
                            }
                            if (n97 == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[33], n96 - 21, n98 - 62, 0, 132, 56, 62);
                                break;
                            }
                            if (n97 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[33], n96 - 21, n98 - 47, 56, 132, 56, 47);
                                break;
                            }
                            break;
                        }
                        case 102: {
                            final int n99 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n99 - 23 <= 240 && n99 + 36 >= 0) {
                                final int n100 = this.uni_pt1[2][this.uni[0][n74][1]][this.uni[0][n74][2]];
                                MyCanvas.g.drawImage(MyCanvas.img[34], n99 - 23, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 63, n100 % 4 * 59, n100 / 4 * 63, 59, 63);
                                break;
                            }
                            break;
                        }
                        case 103: {
                            final int n101 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n101 - 83 > 240 || n101 + 49 < 0) {
                                break;
                            }
                            final int n102 = this.uni_pt1[3][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n103 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n102 == 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 103, 70, 0, 41, 103);
                                break;
                            }
                            if (n102 == 1) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 104, 111, 0, 44, 104);
                                break;
                            }
                            if (n102 == 2) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 104, 155, 0, 36, 104);
                                break;
                            }
                            if (n102 == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101 - 3, n103 - 103, 0, 158, 40, 103);
                                break;
                            }
                            if (n102 == 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 104, 40, 158, 40, 104);
                                break;
                            }
                            if (n102 == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 104, 80, 158, 36, 104);
                                break;
                            }
                            if (n102 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101 + 2, n103 - 158, 0, 0, 34, 158);
                                break;
                            }
                            if (n102 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101, n103 - 158, 34, 0, 36, 158);
                                break;
                            }
                            if (n102 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101 - 83, n103 - 124, 116, 104, 123, 124);
                                break;
                            }
                            if (n102 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[35], n101 - 1, n103 - 103, 191, 0, 48, 103);
                                break;
                            }
                            break;
                        }
                        case 104: {
                            final int n104 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n104 - 22 <= 240 && n104 + 61 >= 0) {
                                final int n105 = this.uni_pt1[4][this.uni[0][n74][1]][this.uni[0][n74][2]];
                                MyCanvas.g.drawImage(MyCanvas.img[36], n104 - 22, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 62, n105 % 2 * 81, n105 / 2 * 62, 81, 62);
                                break;
                            }
                            break;
                        }
                        case 105: {
                            final int n106 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n106 - 57 > 240 || n106 + 52 < 0) {
                                break;
                            }
                            final int n107 = this.uni_pt1[5][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n108 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;

                            if (n107 == 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 17, n108 - 77, 0, 0, 69, 77);
                                break;
                            }
                            if (n107 == 1) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 17, n108 - 80, 69, 0, 67, 80);
                                break;
                            }
                            if (n107 == 2) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 17, n108 - 78, 136, 0, 66, 78);
                                break;
                            }
                            if (n107 == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 17, n108 - 78, 0, 77, 64, 78);
                                break;
                            }
                            if (n107 == 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 4, n108 - 96, 64, 80, 56, 96);
                                break;
                            }
                            if (n107 == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 4, n108 - 97, 120, 80, 41, 97);
                                break;
                            }
                            if (n107 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 4, n108 - 98, 161, 80, 56, 98);
                                break;
                            }
                            if (n107 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 4, n108 - 98, 0, 155, 37, 98);
                                break;
                            }
                            if (n107 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 57, n108 - 82, 37, 177, 89, 82);
                                break;
                            }
                            if (n107 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[37], n106 - 57, n108 - 66, 126, 178, 97, 66);
                                break;
                            }
                            break;
                        }
                        case 106: {
                            final int n109 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n109 - 9 > 240 || n109 + 67 < 0) {
                                break;
                            }
                            final int n110 = this.uni_pt1[6][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n111 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n110 >= 0 && n110 <= 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[38], n109 - 2, n111 - 53, n110 % 3 * 69, n110 / 3 * 53, 69, 53);
                                break;
                            }
                            if (n110 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[38], n109 - 3, n111 - 72, 138, 106, 70, 72);
                                break;
                            }
                            if (n110 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[38], n109 - 2, n111 - 74, 0, 159, 70, 74);
                                break;
                            }
                            if (n110 == 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[38], n109 - 9, n111 - 67, 70, 178, 72, 67);
                                break;
                            }
                            if (n110 == 11) {
                                MyCanvas.g.drawImage(MyCanvas.img[38], n109 - 7, n111 - 51, 142, 178, 69, 51);
                                break;
                            }
                            break;
                        }
                        case 107: {
                            final int n112 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n112 - 73 > 240 || n112 + 49 < 0) {
                                break;
                            }
                            final int n113 = this.uni_pt1[7][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n114 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n113 >= 0 && n113 <= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[39], n112 - 4, n114 - 45, n113 % 4 * 53, n113 / 4 * 45, 53, 45);
                                break;
                            }
                            if (n113 >= 7 && n113 <= 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[39], n112 - 73, n114 - 40, 0, 90 + (n113 - 7) * 40, 122, 40);
                                break;
                            }
                            break;
                        }
                        case 108: {
                            final int n115 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n115 - 52 > 240 || n115 + 65 < 0) {
                                break;
                            }
                            final int n116 = this.uni_pt1[8][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n117 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n116 >= 0 && n116 <= 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 4, n117 - 43, 48 + n116 % 3 * 53, n116 / 3 * 43, 53, 43);
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 3, n117 - (111 + this.hati1[n116]), 0, 0, 48, 104);
                                break;
                            }
                            if (n116 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 4, n117 - 43, 88, 213, 53, 43);
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 3, n117 - 115, 0, 0, 48, 104);
                                break;
                            }
                            if (n116 >= 7 && n116 <= 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 36, n117 - 102 - n116, 0, 104, 101, 109);
                                break;
                            }
                            if (n116 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 32, n117 - 94, 101, 104, 89, 94);
                                break;
                            }
                            if (n116 < 10 || n116 > 13) {
                                break;
                            }
                            MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 31, n117 - 85, 0, 213, 88, 85);
                            if (n116 >= 10 && n116 <= 12) {
                                MyCanvas.g.drawImage(MyCanvas.img[40], n115 - 52, n117 - 17, 48 + (n116 - 10) * 55, 86, 55, 16);
                                break;
                            }
                            break;
                        }
                        case 110: {
                            final int n118 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n118 - 6 <= 240 && n118 + 43 >= 0) {
                                final int n119 = this.uni_pt2[0][this.uni[0][n74][1]][this.uni[0][n74][2]];
                                MyCanvas.g.drawImage(MyCanvas.img[42], n118 - 6, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 40, n119 % 4 * 49, n119 / 4 * 40, 49, 40);
                                break;
                            }
                            break;
                        }
                        case 111: {
                            final int n120 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n120 - 31 > 240 || n120 + 49 < 0) {
                                break;
                            }
                            final int n121 = this.uni_pt2[1][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n122 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n121 >= 0 && n121 <= 2) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120, n122 - 61, n121 * 35, 0, 35, 62);
                                break;
                            }
                            if (n121 >= 3 && n121 <= 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120 - 2, n122 - 74, (n121 - 3) * 38, 62, 38, 75);
                                break;
                            }
                            if (n121 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120 - 31, n122 - 51, 114, 0, 80, 52);
                                break;
                            }
                            if (n121 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120 - 31, n122 - 25, 114, 52, 80, 26);
                                break;
                            }
                            if (n121 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120 - 31, n122 - 24, 114, 78, 80, 25);
                                break;
                            }
                            if (n121 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[43], n120 - 31, n122 - 24, 114, 103, 80, 25);
                                break;
                            }
                            break;
                        }
                        case 112: {
                            final int n123 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n123 - 30 <= 240 && n123 + 41 >= 0) {
                                final int n124 = this.uni_pt2[2][this.uni[0][n74][1]][this.uni[0][n74][2]];
                                MyCanvas.g.drawImage(MyCanvas.img[44], n123 - 30, this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2 - 63, n124 % 3 * 71, n124 / 3 * 63, 71, 63);
                                break;
                            }
                            break;
                        }
                        case 113: {
                            final int n125 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n125 - 71 > 240 || n125 + 46 < 0) {
                                break;
                            }
                            final int n126 = this.uni_pt2[3][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n127 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n126 == 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125, n127 - 103, 0, 0, 36, 104);
                                break;
                            }
                            if (n126 == 1) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125, n127 - 104, 36, 0, 36, 105);
                                break;
                            }
                            if (n126 == 2) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 - 7, n127 - 104, 72, 0, 45, 105);
                                break;
                            }
                            if (n126 == 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 - 7, n127 - 103, 117, 0, 51, 104);
                                break;
                            }
                            if (n126 == 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125, n127 - 104, 0, 105, 46, 105);
                                break;
                            }
                            if (n126 == 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125, n127 - 104, 46, 105, 36, 105);
                                break;
                            }
                            if (n126 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 - 6, n127 - 100, 82, 105, 48, 101);
                                break;
                            }
                            if (n126 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 - 9, n127 - 98, 130, 105, 45, 99);
                                break;
                            }
                            if (n126 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 - 71, n127 - 97, 0, 210, 106, 98);
                                break;
                            }
                            if (n126 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 + 2, n127 - 96, 106, 210, 34, 98);
                                break;
                            }
                            if (n126 == 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[45], n125 + 2, n127 - 97, 140, 210, 34, 98);
                                break;
                            }
                            break;
                        }
                        case 114: {
                            final int n128 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n128 - 40 > 240 || n128 + 53 < 0) {
                                break;
                            }
                            final int n129 = this.uni_pt2[4][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n130 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n129 >= 0 && n129 <= 3) {
                                MyCanvas.g.drawImage(MyCanvas.img[46], n128 - 2, n130 - 89, n129 * 53, 0, 53, 89);
                                break;
                            }
                            if (n129 >= 4 && n129 <= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[46], n128 - 1, n130 - 89, (n129 - 4) * 52, 89, 52, 89);
                                break;
                            }
                            if (n129 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[46], n128 - 40, n130 - 79, 0, 178, 91, 79);
                                break;
                            }
                            if (n129 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[46], n128 - 40, n130 - 51, 91, 178, 91, 51);
                                break;
                            }
                            break;
                        }
                        case 115: {
                            final int n131 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n131 - 54 > 240 || n131 + 51 < 0) {
                                break;
                            }
                            final int n132 = this.uni_pt2[5][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n133 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            MyCanvas.g.drawImage(MyCanvas.img[47], n131 + 5, n133 - 3, 110, 86, 31, 3);
                            if (n132 >= 0 && n132 <= 4) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 8, n133 - 87 - n132, 0, 0, 55, 42);
                                break;
                            }
                            if (n132 >= 5 && n132 <= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 8, n133 - 87, 55 + (n132 - 5) * 55, 0, 55, 45);
                                break;
                            }
                            if (n132 == 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 4, n133 - 89, 165, 0, 55, 54);
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 37, n133 - 33, 0, 100, 37, 29);
                                break;
                            }
                            if (n132 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 3, n133 - 89, 0, 45, 55, 53);
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 43, n133 - 22, 0, 129, 27, 22);
                                break;
                            }
                            if (n132 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 3, n133 - 89, 55, 45, 55, 55);
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 52, n133 - 10, 0, 151, 27, 10);
                                break;
                            }
                            if (n132 == 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 6, n133 - 88, 110, 45, 55, 41);
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 53, n133 - 13, 0, 161, 27, 13);
                                break;
                            }
                            if (n132 == 11) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 7, n133 - 87, 165, 54, 55, 41);
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 54, n133 - 100, 37, 100, 29, 100);
                                break;
                            }
                            if (n132 < 12 || n132 > 15) {
                                break;
                            }
                            MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 8, n133 - 87, 0, 0, 55, 42);
                            if (n132 == 12) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 54, n133 - 104, 66, 100, 29, 104);
                                break;
                            }
                            if (n132 == 13) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 53, n133 - 106, 95, 100, 27, 106);
                                break;
                            }
                            if (n132 == 14) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 53, n133 - 103, 122, 100, 27, 103);
                                break;
                            }
                            if (n132 == 15) {
                                MyCanvas.g.drawImage(MyCanvas.img[47], n131 - 54, n133 - 104, 149, 100, 29, 104);
                                break;
                            }
                            break;
                        }
                        case 116: {
                            final int n134 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n134 - 7 > 240 || n134 + 73 < 0) {
                                break;
                            }
                            final int n135 = this.uni_pt2[6][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n136 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n135 >= 0 && n135 <= 7) {
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 7, n136 - 58, n135 % 3 * 76, n135 / 3 * 58, 76, 58);
                                break;
                            }
                            if (n135 == 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 6, n136 - 100, 152, 116, 79, 100);
                                break;
                            }
                            if (n135 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 6, n136 - 105, 0, 174, 79, 105);
                                break;
                            }
                            if (n135 == 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 16, n136 - 39, 79, 216, 88, 39);
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 16, n136 - 94, 167, 216, 69, 55);
                                break;
                            }
                            if (n135 == 11) {
                                MyCanvas.g.drawImage(MyCanvas.img[48], n134 - 15, n136 - 48, 79, 255, 86, 48);
                                break;
                            }
                            break;
                        }
                        case 117: {
                            final int n137 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n137 - 69 > 240 || n137 + 74 < 0) {
                                break;
                            }
                            final int n138 = this.uni_pt2[7][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n139 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n138 >= 0 && n138 <= 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[49], n137 - 3, n139 - 99, n138 % 3 * 63, n138 / 3 * 99, 63, 99);
                                break;
                            }
                            if (n138 >= 7 && n138 <= 10) {
                                MyCanvas.g.drawImage(MyCanvas.img[49], n137 - 39, n139 - 50, 63, 198, 113, 50);
                                MyCanvas.g.drawImage(MyCanvas.img[49], n137 - 75, n139 - 69, 189, (n138 - 7) * 69, 39, 69);
                                break;
                            }
                            break;
                        }
                        case 118: {
                            final int n140 = (this.uni[0][n74][3] - this.p_flg[5]) / 10;
                            if (n140 - 49 > 240 || n140 + 33 < 0) {
                                break;
                            }
                            final int n141 = this.uni_pt2[8][this.uni[0][n74][1]][this.uni[0][n74][2]];
                            final int n142 = this.uni[0][n74][4] / 10 + this.uni[0][n74][5] * 2;
                            if (n141 >= 0 && n141 <= 5) {
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 4, n142 - 43, 70 + n141 % 3 * 53, n141 / 3 * 43, 53, 43);
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 6, n142 - (80 + this.hati1[n141]), 0, 32, 54, 73);
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 + 3, n142 - (112 + this.hati1[n141]), this.uni[0][n74][2] % 2 * 35, 0, 35, 32);
                                break;
                            }
                            if (n141 == 6) {
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 4, n142 - 43, 159, 250, 53, 43);
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 6, n142 - 84, 0, 32, 54, 73);
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 + 3, n142 - 116, this.uni[0][n74][2] % 2 * 35, 0, 35, 32);
                                break;
                            }
                            if (n141 >= 7 && n141 <= 8) {
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 36, n142 - 101 - n141, 0, 105, 101, 108);
                                break;
                            }
                            if (n141 == 9) {
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 32, n142 - 94, 101, 105, 90, 94);
                                break;
                            }
                            if (n141 < 10 || n141 > 13) {
                                break;
                            }
                            MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 32, n142 - 88, 0, 213, 90, 90);
                            if (n141 >= 10 && n141 <= 12) {
                                MyCanvas.g.drawImage(MyCanvas.img[50], n140 - 49, n142 - 50, 101 + (n141 - 10) / 2 * 58, 199 + (n141 - 10) % 2 * 51, 58, 51);
                                break;
                            }
                            break;
                        }
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39: {
                            this.teki_b(MyCanvas.g, this.z_tbl[n73][1] - 8, (this.uni[1][n74][3] - this.p_flg[5]) / 10, this.uni[1][n74][4] / 10 + this.uni[1][n74][5] * 2, this.uni[1][n74][1], this.uni[1][n74][2]);
                            break;
                        }
                    }
                }
                for (int n143 = 0; n143 < this.ef1.length; ++n143) {
                    for (int n144 = 0; n144 < this.ef1[n143].length; ++n144) {
                        if (this.ef1[n143][n144][0] > 0) {
                            final int n145 = (this.ef1[n143][n144][1] - this.p_flg[5]) / 10;
                            if (n145 <= 240 && n145 + 55 >= 0) {
                                MyCanvas.g.drawImage(MyCanvas.img[28], n145, this.ef1[n143][n144][2] / 10, 0, (5 - (this.ef1[n143][n144][0] - 1)) * 47, 55, 47);
                            }
                        }
                    }
                }
                if (this.uni[0][0][9] == 1) {
                    final int n146 = (this.uni[0][0][3] - this.p_flg[5]) / 10 + 11;
                    final int n147 = n146 - (this.uni[0][0][6] * this.nyan3 - 37) * this.uni[0][0][10] / 8;
                    final int n148 = this.uni[0][0][4] / 10 + 64;
                    if (n146 >= 0 && n147 - 12 <= 240) {
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 0, 255));
                        MyCanvas.g.drawLine(n146, n148, n147, 217);
                        MyCanvas.g.drawLine(n146 - 3, n148, n147 - 3, 217);
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        MyCanvas.g.drawLine(n146 - 1, n148, n147 - 1, 217);
                        MyCanvas.g.drawLine(n146 - 2, n148, n147 - 2, 217);
                        MyCanvas.g.drawImage(MyCanvas.img[196], n147 - 12, 197, 148, 131 + this.uni[0][0][10] % 2 * 20, 53, 20);
                    }
                }
                for (int n149 = 0; n149 < this.ef2.length; ++n149) {
                    if (this.ef2[n149][0] != 0) {
                        final int n150 = (this.ef2[n149][1] - this.p_flg[5]) / 10;
                        if (n150 <= 240 && n150 + 74 >= 0) {
                            final int n151 = this.nyan5[this.ef2[n149][0]];
                            MyCanvas.g.drawImage(MyCanvas.img[196], n150, 89, n151 % 3 * 74, n151 / 3 * 131, 74, 131);
                        }
                    }
                }
                if (this.dat[4] == 3) {
                    MyCanvas.g3d.setPrimitiveTexture(0);
                    final int n152 = this.p_flg[5] / 10;
                    for (int n153 = 0; n153 < this.yuki.length; ++n153) {
                        this.setQuad(MyCanvas.pri[2], n153, (this.yuki[n153][0] / 100 - n152 + 28000) % 280 - 20 - 2, this.yuki[n153][1] / 100 - 2, 1000, 5, 5, 0, 0, 5, 5);
                        MyCanvas.pri[2].getNormalArray()[n153 * 3 + 2] = -2048;
                    }
                    MyCanvas.g3d.renderPrimitives(MyCanvas.pri[2], 65);
                    MyCanvas.g3d.flush();
                }
                if (this.uni[0][0][9] == 2 && this.uni[0][0][10] == 1) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    MyCanvas.g.fillRect(0, 0, 240, 240);
                }
                int n154 = 27;
                if (this.p_flg[25] % 2 == 1) {
                    n154 = 262;
                }
                MyCanvas.g.drawImage(MyCanvas.img[n154], 98, -1, 157, 0, 28, 19);
                MyCanvas.g.drawImage(MyCanvas.img[n154], 219, 16, 143, 0, 14, 19);
                int n155 = 205;
                int n156 = this.p_flg[9] / 100;
                do {
                    MyCanvas.g.drawImage(MyCanvas.img[n154], n155, 16, n156 % 10 * 13, 0, 13, 19);
                    n156 /= 10;
                    n155 -= 11;
                } while (n156 > 0);
                MyCanvas.g.drawImage(MyCanvas.img[n154], n155, 16, 130, 0, 13, 19);
                n155 -= 13;
                int n157 = this.p_flg[10] / 100;
                do {
                    MyCanvas.g.drawImage(MyCanvas.img[n154], n155, 16, n157 % 10 * 13, 0, 13, 19);
                    n157 /= 10;
                    n155 -= 11;
                } while (n157 > 0);
                if (this.p_flg[2] == 0) {
                    MyCanvas.g.drawImage(MyCanvas.img[253], 3, 7);
                    int n158 = 36;
                    if (this.uni[0][0][12] == 0) {
                        if (this.p_flg[1] % 2 == 0) {
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 255, 255));
                        }
                        else {
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(150, 255, 255));
                        }
                    }
                    else {
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 255, 255));
                        n158 = 36 * (this.uni[0][0][11] - this.uni[0][0][12]) / this.uni[0][0][11];
                    }
                    MyCanvas.g.fillRect(57, 11, n158, 6);
                    MyCanvas.g.drawImage(MyCanvas.img[31], 89, 25, (this.p_flg2[1][0] + 1) % 10 * 5, 0, 5, 7);
                    MyCanvas.g.drawImage(MyCanvas.img[140 + this.p_flg[20]], 1, 225);
                }
                else {
                    if (this.uni[0][0][12] == 0) {
                        MyCanvas.g.drawImage(MyCanvas.img[24], 3, 3, 0, 0, 46, 34);
                    }
                    else {
                        MyCanvas.g.drawImage(MyCanvas.img[24], 3, 3, 0, 34, 46, 34);
                        final int n159 = 40 * (this.uni[0][0][11] - this.uni[0][0][12]) / this.uni[0][0][11];
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 255, 255));
                        MyCanvas.g.fillRect(6, 31, n159, 3);
                    }
                    if (this.p_flg2[1][0] + 1 == 8) {
                        MyCanvas.g.drawImage(MyCanvas.img[24], 50, 3, 46, 34, 46, 34);
                        MyCanvas.g.drawImage(MyCanvas.img[189], 69, 26);
                    }
                    else if (this.p_flg[10] >= this.nyan10[this.p_flg[11]][this.p_flg2[1][0]]) {
                        MyCanvas.g.drawImage(MyCanvas.img[24], 50, 3, 46, 0, 46, 34);
                        this.kurokane(MyCanvas.g, this.nyan10[this.p_flg[11]][this.p_flg2[1][0]] / 100, 0, 1, 85, 24);
                    }
                    else {
                        MyCanvas.g.drawImage(MyCanvas.img[24], 50, 3, 46, 34, 46, 34);
                        this.kurokane(MyCanvas.g, this.nyan10[this.p_flg[11]][this.p_flg2[1][0]] / 100, 1, 1, 85, 24);
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[198], 3, 38);
                    for (int n160 = 0; n160 < 9; ++n160) {
                        int n161 = 0;
                        final int n162 = n160 + 1;
                        if (this.p_flg2[n160 + 2][0] == 10) {
                            n161 = 1;
                        }
                        if (this.p_flg2[n160 + 2][0] == 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[4 + n160 + 10 * n161], 3 + n162 % 5 * 47, 38 + n162 / 5 * 35, 0, 68, 46, 34);
                        }
                        else if (this.p_flg2[n160 + 2][1] != 0) {
                            MyCanvas.g.drawImage(MyCanvas.img[4 + n160 + 10 * n161], 3 + n162 % 5 * 47, 38 + n162 / 5 * 35, 0, 34, 46, 34);
                            int n163 = this.uni_dat1[n160 + 2][this.p_flg2[n160 + 2][0] - 1][7] - this.nyan12[this.save3[8]] - this.ta7[2] * this.p_flg3[2] / 100;
                            if (n163 <= 1) {
                                n163 = 1;
                            }
                            int n164 = 40 * (n163 - this.p_flg2[n160 + 2][1]) / n163;
                            if (n164 > 40) {
                                n164 = 40;
                            }
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                            MyCanvas.g.fillRect(3 + n162 % 5 * 47 + 2, 38 + n162 / 5 * 35 + 27, 42, 5);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 255, 255));
                            MyCanvas.g.fillRect(3 + n162 % 5 * 47 + 3, 38 + n162 / 5 * 35 + 28, n164, 3);
                        }
                        else if (this.p_flg[10] < this.uni_dat1[n160 + 2][this.p_flg2[n160 + 2][0] - 1][6]) {
                            MyCanvas.g.drawImage(MyCanvas.img[4 + n160 + 10 * n161], 3 + n162 % 5 * 47, 38 + n162 / 5 * 35, 0, 34, 46, 34);
                            this.kurokane(MyCanvas.g, this.uni_dat1[n160 + 2][this.p_flg2[n160 + 2][0] - 1][6] / 100, 1, 1, 3 + n162 % 5 * 47 + 35, 38 + n162 / 5 * 35 + 21);
                        }
                        else {
                            MyCanvas.g.drawImage(MyCanvas.img[4 + n160 + 10 * n161], 3 + n162 % 5 * 47, 38 + n162 / 5 * 35, 0, 0, 46, 34);
                            this.kurokane(MyCanvas.g, this.uni_dat1[n160 + 2][this.p_flg2[n160 + 2][0] - 1][6] / 100, 0, 1, 3 + n162 % 5 * 47 + 35, 38 + n162 / 5 * 35 + 21);
                        }
                    }
                    MyCanvas.g.drawImage(MyCanvas.img[25], 1 + this.p_flg[3] % 5 * 47, 1 + this.p_flg[3] / 5 * 35, this.p_flg[4] % 2 * 50, 0, 50, 38);
                    this.setQuad2(MyCanvas.pri[0], 0, 1, 206, 1000, 238, 33);
                    MyCanvas.pri[0].getColorArray()[0] = 8421504;
                    MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                    MyCanvas.g3d.flush();
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    if (this.c_dai[0] == 0) {
                        int n165 = this.p_flg[3] * 2;
                        if (this.p_flg[3] >= 6) {
                            if (this.p_flg2[this.p_flg[3] - 4][0] == 10) {
                                n165 += 18;
                            }
                            if (this.p_flg2[this.p_flg[3] - 4][0] == 0) {
                                n165 = 48;
                            }
                        }
                        boolean b = false;
                        if (this.p_flg[3] == 1 && this.p_flg2[1][0] != 7 && this.p_flg[9] < this.nyan10[this.p_flg[11]][this.p_flg2[1][0]]) {
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u3010\u50cd\u304d\u30cd\u30b3\u3011", 7, 210);
                            if (this.p_flg[1] % 4 <= 1) {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 0, 255));
                            }
                            else {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                            }
                            final int stringWidth3 = MyCanvas.font[MyCanvas.sivar[11]].stringWidth("\u3010\u50cd\u304d\u30cd\u30b3\u3011");
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\u304a\u8ca1\u5e03\uff7b\uff72\uff7d\uff9e\u304c\u8db3\u3089\u306a\u3044\u305e\uff01", 7 + stringWidth3, 210);
                            MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, "\uff8a\uff9f\uff9c\uff70\uff71\uff6f\uff8c\uff9f\u3067\u304a\u8ca1\u5e03\uff7b\uff72\uff7d\uff9e\u3092\u5f37\u5316\u3059\u308b\u306e\u3060\u266a", 7, 224);
                            b = true;
                        }
                        if (!b) {
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, this.s_moji[n165], 7, 210);
                            if (this.p_flg[3] == 5) {
                                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                            }
                            MyCanvas.sivar[12] = 5;
                            this.drawString(MyCanvas.g, this.s_moji[n165 + 1], 7, 224);
                        }
                    }
                    else {
                        MyCanvas.sivar[12] = 5;
                        this.drawString(MyCanvas.g, this.c_moji[this.c_dai[0]], 7, 210);
                    }
                }
                if (this.p_flg[14] == 1) {
                    this.sen2(MyCanvas.g);
                }
                else if (this.p_flg[14] == 2) {
                    this.sen3(MyCanvas.g);
                }
                else if (this.p_flg[14] == 3) {
                    if (this.save3[1] == 0) {
                        this.sen1(MyCanvas.g);
                    }
                }
                else if (this.p_flg[14] == 4) {
                    this.sen4(MyCanvas.g);
                }
                else if (this.p_flg[14] == 5) {
                    this.sen5(MyCanvas.g);
                }
                if (MyCanvas.sivar[2] != 401) {
                    break;
                }
                final int n166 = this.kiri_tbl2[this.kiri[0]];
                final Graphics g2 = MyCanvas.g;
                final Graphics g3 = MyCanvas.g;
                g2.setFlipMode(1);
                MyCanvas.g.drawImage(MyCanvas.img[227], n166, 0);
                final Graphics g4 = MyCanvas.g;
                final Graphics g5 = MyCanvas.g;
                g4.setFlipMode(0);
                if (n166 > 0) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                    MyCanvas.g.fillRect(0, 0, n166, 240);
                    break;
                }
                break;
            }
            case 500: {
                MyCanvas.g.drawImage(MyCanvas.img[228], 0, 0);
                int n167 = 30;
                if (this.p_flg[3] == 1) {
                    n167 = 60;
                }
                int n168;
                if (this.p_flg[4] > n167 / 2) {
                    n168 = 20 * (n167 - this.p_flg[4]) / (n167 / 2);
                }
                else {
                    n168 = 20 * (n167 / 2 - (n167 / 2 - this.p_flg[4])) / (n167 / 2);
                }
                if (n168 > 0) {
                    this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                    MyCanvas.pri[0].getColorArray()[0] = (n168 << 16 | n168 << 8 | n168);
                    MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                    MyCanvas.g3d.flush();
                }
                MyCanvas.g3d.setPrimitiveTexture(0);
                for (int n169 = 0; n169 < this.hinoko.length; ++n169) {
                    final int n170 = (this.hinoko[n169][0] + this.cos(this.hinoko[n169][2] * this.hinoko[n169][5] % 512) * this.hinoko[n169][4] / 4096) / 100;
                    final int n171 = this.hinoko[n169][1] / 100;
                    this.setQuad(MyCanvas.pri[2], n169, n170, n171, 1000, 5, 5, 5, 0, 5, 5);
                    this.setQuadR(MyCanvas.pri[2], n169, n170 + 2, n171 + 2, this.hinoko[n169][2] * this.hinoko[n169][5] % 512);
                    int n172 = (n171 - 60) * 100 / 180;
                    if (n172 > 100) {
                        n172 = 100;
                    }
                    else if (n172 < 0) {
                        n172 = 0;
                    }
                    MyCanvas.pri[2].getNormalArray()[n169 * 3 + 2] = 1024 * n172 / 50 * -1;
                }
                MyCanvas.g3d.renderPrimitives(MyCanvas.pri[2], 65);
                MyCanvas.g3d.flush();
                if (this.p_flg[0] >= 1) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    for (int n173 = 0; n173 < this.op_moji.length; ++n173) {
                        final int n174 = n173 * 16 + 240 - this.p_flg[2];
                        if (n174 > -12 && n174 < 240) {
                            MyCanvas.sivar[12] = 4;
                            if (n173 == 0) {
                                if (this.nen < 2010) {
                                    this.drawString(MyCanvas.g, "20XX" + this.op_moji[n173], 120, n174);
                                }
                                else {
                                    this.drawString(MyCanvas.g, Integer.toString(this.nen) + this.op_moji[n173], 120, n174);
                                }
                            }
                            else {
                                this.drawString(MyCanvas.g, this.op_moji[n173], 120, n174);
                            }
                        }
                    }
                }
                this.setQuad2(MyCanvas.pri[1], 0, 0, 0, 1000, 240, 60);
                MyCanvas.pri[1].getNormalArray()[2] = -4096;
                MyCanvas.pri[1].getNormalArray()[5] = 0;
                MyCanvas.pri[1].getNormalArray()[8] = 0;
                MyCanvas.pri[1].getNormalArray()[11] = -4096;
                MyCanvas.pri[1].getColorArray()[0] = 16777215;
                MyCanvas.g3d.renderPrimitives(MyCanvas.pri[1], 97);
                MyCanvas.g3d.flush();
                int n175 = 0;
                if (this.p_flg[0] == 0) {
                    int n176 = 50 - this.p_flg[1];
                    if (n176 > 45) {
                        n176 = 45;
                    }
                    n175 = 255 * n176 / 45;
                }
                else if (this.p_flg[0] == 2) {
                    int n177 = this.p_flg[1];
                    if (n177 > 75) {
                        n177 = 75;
                    }
                    n175 = 255 * n177 / 75;
                }
                if (n175 != 0) {
                    this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                    MyCanvas.pri[0].getColorArray()[0] = (n175 << 16 | n175 << 8 | n175);
                    MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                    MyCanvas.g3d.flush();
                    break;
                }
                break;
            }
            case 501: {
                MyCanvas.g.drawImage(MyCanvas.img[255], 0, 0);
                MyCanvas.g3d.setPrimitiveTexture(0);
                for (int n178 = 0; n178 < this.hinoko.length; ++n178) {
                    final int n179 = (this.hinoko[n178][0] + this.cos(this.hinoko[n178][2] * this.hinoko[n178][5] % 512) * this.hinoko[n178][4] / 4096) / 100;
                    final int n180 = this.hinoko[n178][1] / 100;
                    this.setQuad(MyCanvas.pri[2], n178, n179, n180, 1000, 5, 5, 5, 0, 5, 5);
                    this.setQuadR(MyCanvas.pri[2], n178, n179 + 2, n180 + 2, this.hinoko[n178][2] * this.hinoko[n178][5] % 512);
                    int n181 = (n180 - 60) * 100 / 180;
                    if (n181 > 100) {
                        n181 = 100;
                    }
                    else if (n181 < 0) {
                        n181 = 0;
                    }
                    MyCanvas.pri[2].getNormalArray()[n178 * 3 + 2] = 1024 * n181 / 50 * -1;
                }
                MyCanvas.g3d.renderPrimitives(MyCanvas.pri[2], 65);
                MyCanvas.g3d.flush();
                MyCanvas.g.drawImage(MyCanvas.img[53], 138, 140);
                if (this.p_flg[0] >= 1) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    for (int n182 = 0; n182 < this.ed_moji.length; ++n182) {
                        final int n183 = n182 * 16 + 240 - this.p_flg[2];
                        if (n183 > -12 && n183 < 240) {
                            MyCanvas.sivar[12] = 4;
                            this.drawString(MyCanvas.g, this.ed_moji[n182], 120, n183);
                        }
                    }
                    final int n184 = this.ed_moji.length * 16 + 240 - this.p_flg[2];
                    if (n184 < 240) {
                        MyCanvas.g.drawImage(MyCanvas.img[256], 14, n184);
                    }
                }
                int n185 = 0;
                if (this.p_flg[0] == 0) {
                    int n186 = 50 - this.p_flg[1];
                    if (n186 > 45) {
                        n186 = 45;
                    }
                    n185 = 255 * n186 / 45;
                }
                else if (this.p_flg[0] == 3) {
                    int n187 = this.p_flg[1];
                    if (n187 > 45) {
                        n187 = 45;
                    }
                    n185 = 255 * n187 / 45;
                }
                if (n185 != 0) {
                    this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
                    MyCanvas.pri[0].getColorArray()[0] = (n185 << 16 | n185 << 8 | n185);
                    MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
                    MyCanvas.g3d.flush();
                    break;
                }
                break;
            }
            case 502: {
                MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                MyCanvas.g.fillRect(0, 0, 240, 240);
                if (this.p_flg[0] == 0) {
                    this.box(MyCanvas.g, 33, 96, 174, 48);
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    MyCanvas.sivar[12] = 4;
                    this.drawString(MyCanvas.g, "\u30bf\u30a4\u30c8\u30eb\u753b\u9762\u304b\u3089", 120, 99);
                    final String str3 = "\u30c1\u30e3\u30ec\u30f3\u30b8\u30d0\u30c8\u30eb";
                    final String str4 = "\u304c";
                    final int stringWidth4 = MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str3);
                    final int n188 = (240 - MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str3 + str4)) / 2;
                    if (this.p_flg[5] % 2 == 0) {
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 0));
                    }
                    else {
                        MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 0, 255));
                    }
                    MyCanvas.sivar[12] = 5;
                    this.drawString(MyCanvas.g, str3, n188, 114);
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    MyCanvas.sivar[12] = 5;
                    this.drawString(MyCanvas.g, str4, stringWidth4 + n188, 114);
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    MyCanvas.sivar[12] = 4;
                    this.drawString(MyCanvas.g, "\u9078\u3079\u308b\u3088\u3046\u306b\u306a\u308a\u307e\u3057\u305f\uff01", 120, 129);
                }
                if (this.p_flg[0] == 1) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(180, 180, 180));
                    MyCanvas.sivar[12] = 10;
                    this.drawString(MyCanvas.g, "Now Loading...", 239, 239);
                    break;
                }
                break;
            }
            case 20: {
                MyCanvas.g.setColor(Graphics.getColorOfRGB(0, 0, 0));
                MyCanvas.g.fillRect(0, 0, 240, 240);
                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 255, 255));
                MyCanvas.sivar[12] = 4;
                this.drawString(MyCanvas.g, "\u30b2\u30fc\u30e0\u30c7\u30fc\u30bf\u3092\u30c0\u30a6\u30f3\u30ed\u30fc\u30c9\u3057\u307e\u3059", 120, 95);
                MyCanvas.sivar[12] = 4;
                this.drawString(MyCanvas.g, "\uff08\u521d\u56de\u8d77\u52d5\u6642\u306e\u307f\uff09", 120, 115);
                MyCanvas.sivar[12] = 4;
                this.drawString(MyCanvas.g, "\u4f55\u304b\u30ad\u30fc\u3092\u62bc\u3057\u3066\u304f\u3060\u3055\u3044", 120, 145);
                break;
            }
            case 0: {
                MyCanvas.g.fillRect(0, 0, this.getWidth(), this.getHeight());
                break;
            }
            case 1:
            case 2: {
                MyCanvas.g.fillRect(0, 0, this.getWidth(), this.getHeight());
                MyCanvas.g.setColor(Graphics.getColorOfRGB(160, 0, 0));
                MyCanvas.g.fillRect(5, 119, 230, 5);
                MyCanvas.g.setColor(Graphics.getColorOfRGB(255, 0, 0));
                if (MyCanvas.sivar[17] > 0) {
                    MyCanvas.g.fillRect(5, 119, 230 * MyCanvas.sivar[18] / MyCanvas.sivar[17], 5);
                }
                MyCanvas.g.drawImage(MyCanvas.load_img, 57, 99);
                if (MyCanvas.sivar[2] == 1) {
                    MyCanvas.g.setColor(Graphics.getColorOfRGB(130, 130, 130));
                    final Graphics g6 = MyCanvas.g;
                    final Font[] font2 = MyCanvas.font;
                    final int[] sivar2 = MyCanvas.sivar;
                    final int n189 = 11;
                    final int n190 = 1;
                    sivar2[n189] = n190;
                    g6.setFont(font2[n190]);
                    MyCanvas.sivar[12] = 4;
                    this.drawString(MyCanvas.g, "Now Downloading...", 120, 130);
                    break;
                }
                break;
            }
        }
        if (MyCanvas.wnd_param[6][1] != 0) {
            this.drawWnd(MyCanvas.g);
        }
        MyCanvas.g.unlock(false);
    }
    
    public void taikenkokuti() {
        this.setScene(20);
        while (true) {
            MyCanvas.sivar[13] = MyCanvas.sivar[14];
            MyCanvas.sivar[14] = 0;
            MyCanvas.sivar[15] = this.getKeypadState();
            if (MyCanvas.sivar[13] != 0) {
                break;
            }
            this.myPaint();
            try {
                Thread.sleep(66L);
            }
            catch (final Exception ex) {}
        }
        this.setScene(0);
    }
    
    public void sach(final int n) {
        this.play(18);
        if (n == 0) {
            if (this.p_flg[12] == 0 || this.p_flg[12] == 3) {
                if (this.p_flg[13] == 0) {
                    this.p_flg[12] = 1;
                }
                else {
                    this.p_flg[12] = 2;
                }
                final int[] p_flg = this.p_flg;
                final int n2 = 13;
                p_flg[n2] ^= 0x1;
            }
            else {
                if (this.p_flg[12] == 2) {
                    this.p_flg[12] = 1;
                }
                else {
                    this.p_flg[12] = 2;
                }
                final int[] p_flg2 = this.p_flg;
                final int n3 = 13;
                p_flg2[n3] ^= 0x1;
            }
            if (this.p_flg[12] == 1) {
                if (this.p_flg[5] == this.dat[0] - 2400) {
                    this.p_flg[12] = 2;
                    final int[] p_flg3 = this.p_flg;
                    final int n4 = 13;
                    p_flg3[n4] ^= 0x1;
                }
            }
            else if (this.p_flg[5] == 0) {
                this.p_flg[12] = 1;
                final int[] p_flg4 = this.p_flg;
                final int n5 = 13;
                p_flg4[n5] ^= 0x1;
            }
        }
        else {
            this.p_flg[12] = 3;
        }
    }
    
    public void teki_b(final Graphics graphics, final int n, final int n2, final int n3, final int n4, final int n5) {
        switch (n) {
            case 2: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n6 = this.uni_pt3[0][n4][n5];
                    graphics.drawImage(MyCanvas.img[60], n2 - 36, n3 - 40, n6 % 6 * 36, n6 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 3: {
                if (n2 - 42 <= 240 && n2 + 11 >= 0) {
                    final int n7 = this.uni_pt3[1][n4][n5];
                    graphics.drawImage(MyCanvas.img[61], n2 - 42, n3 - 43, n7 % 4 * 53, n7 / 4 * 43, 53, 43);
                    break;
                }
                break;
            }
            case 4: {
                if (n2 - 39 <= 240 && n2 + 7 >= 0) {
                    final int n8 = this.uni_pt3[2][n4][n5];
                    graphics.drawImage(MyCanvas.img[62], n2 - 39, n3 - 32, n8 % 5 * 46, n8 / 5 * 32, 46, 32);
                    break;
                }
                break;
            }
            case 5: {
                if (n2 - 70 <= 240 && n2 + 8 >= 0) {
                    final int n9 = this.uni_pt3[3][n4][n5];
                    graphics.drawImage(MyCanvas.img[63], n2 - 70, n3 - 72, n9 % 3 * 78, n9 / 3 * 72, 78, 72);
                    break;
                }
                break;
            }
            case 6: {
                if (n2 - 77 > 240 || n2 + 17 < 0) {
                    break;
                }
                final int n10 = this.uni_pt3[4][n4][n5];
                if (n10 >= 0 && n10 <= 2) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 69, n3 - 54, 0, n10 * 54, 78, 54);
                    break;
                }
                if (n10 == 3) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 69, n3 - 51, 0, 162, 78, 51);
                    break;
                }
                if (n10 == 4) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 69, n3 - 48, 0, 213, 78, 48);
                    break;
                }
                if (n10 >= 5 && n10 <= 6) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 58, n3 - 3, 78, 267, 52, 3);
                    graphics.drawImage(MyCanvas.img[64], n2 - 67, n3 - 72 - n10, 0, 261, 74, 53);
                    break;
                }
                if (n10 == 7) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 74, n3 - 74, 78, 0, 91, 75);
                    break;
                }
                if (n10 >= 8 && n10 <= 11) {
                    graphics.drawImage(MyCanvas.img[64], n2 - 77, n3 - 48, 78, 75 + (n10 - 8) * 48, 92, 48);
                    break;
                }
                break;
            }
            case 7: {
                if (n2 - 57 > 240 || n2 + 23 < 0) {
                    break;
                }
                final int n11 = this.uni_pt3[5][n4][n5];
                if (n11 >= 0 && n11 <= 10) {
                    graphics.drawImage(MyCanvas.img[65], n2 - 44, n3 - 63, n11 % 5 * 46, n11 / 5 * 63, 46, 63);
                    break;
                }
                if (n11 >= 11 && n11 <= 12) {
                    graphics.drawImage(MyCanvas.img[65], n2 - 41, n3 - 61, 46 + (n11 - 11) * 42, 126, 42, 61);
                    break;
                }
                if (n11 == 13) {
                    graphics.drawImage(MyCanvas.img[65], n2 - 57, n3 - 97, 130, 126, 80, 97);
                    break;
                }
                if (n11 >= 14 && n11 <= 17) {
                    graphics.drawImage(MyCanvas.img[65], n2 - 37, n3 - 3, 124, 223, 31, 3);
                    graphics.drawImage(MyCanvas.img[65], n2 - 52, n3 - 89, (n11 - 14) % 2 * 62, 189 + (n11 - 14) / 2 * 48, 62, 48);
                    break;
                }
                break;
            }
            case 8: {
                if (n2 - 59 > 240 || n2 + 18 < 0) {
                    break;
                }
                final int n12 = this.uni_pt3[6][n4][n5];
                if (n12 >= 0 && n12 <= 5) {
                    graphics.drawImage(MyCanvas.img[66], n2 - 55, n3 - 61, n12 % 4 * 52, n12 / 4 * 61, 52, 61);
                    break;
                }
                if (n12 >= 6 && n12 <= 7) {
                    graphics.drawImage(MyCanvas.img[66], n2 - 59, n3 - 73, 104 + (n12 - 6) * 54, 61, 54, 73);
                    break;
                }
                if (n12 == 8) {
                    graphics.drawImage(MyCanvas.img[66], n2 - 54, n3 - 64, 0, 122, 71, 64);
                    break;
                }
                if (n12 >= 9 && n12 <= 10) {
                    graphics.drawImage(MyCanvas.img[66], n2 - 54, n3 - 54, 71 + (n12 - 9) * 72, 134, 72, 54);
                    break;
                }
                if (n12 == 11) {
                    graphics.drawImage(MyCanvas.img[66], n2 - 54, n3 - 54, 0, 186, 64, 54);
                    break;
                }
                break;
            }
            case 9: {
                if (n2 - 61 > 240 || n2 + 37 < 0) {
                    break;
                }
                final int n13 = this.uni_pt3[7][n4][n5];
                if (n13 >= 0 && n13 <= 2) {
                    graphics.drawImage(MyCanvas.img[67], n2 - 52, n3 - 52, 0, n13 * 52, 57, 52);
                    break;
                }
                if (n13 >= 3 && n13 <= 6) {
                    graphics.drawImage(MyCanvas.img[67], n2 - 58, n3 - 52, 57 + (n13 - 3) / 3 * 62, (n13 - 3) % 3 * 52, 62, 52);
                    break;
                }
                if (n13 == 7) {
                    graphics.drawImage(MyCanvas.img[67], n2 - 45, n3 - 3, 79, 156, 40, 4);
                    graphics.drawImage(MyCanvas.img[67], n2 - 51, n3 - 55, 119, 106, 84, 55);
                    break;
                }
                if (n13 == 8) {
                    graphics.drawImage(MyCanvas.img[67], n2 - 45, n3 - 3, 79, 156, 40, 4);
                    graphics.drawImage(MyCanvas.img[67], n2 - 23, n3 - 57, 119, 52, 60, 54);
                    break;
                }
                if (n13 == 9) {
                    graphics.drawImage(MyCanvas.img[67], n2 - 45, n3 - 3, 79, 156, 40, 4);
                    graphics.drawImage(MyCanvas.img[67], n2 - 61, n3 - 63, 119, 52, 60, 54);
                    break;
                }
                break;
            }
            case 10: {
                if (n2 - 77 > 240 || n2 + 6 < 0) {
                    break;
                }
                final int n14 = this.uni_pt3[8][n4][n5];
                if (n14 >= 0 && n14 <= 3) {
                    graphics.drawImage(MyCanvas.img[68], n2 - 76, n3 - 56, 0, n14 * 56, 81, 56);
                    break;
                }
                if (n14 >= 4 && n14 <= 6) {
                    graphics.drawImage(MyCanvas.img[68], n2 - 77, n3 - 78, 81, (n14 - 4) * 78, 83, 78);
                    break;
                }
                if (n14 == 7) {
                    graphics.drawImage(MyCanvas.img[68], n2 - 77, n3 - 54, 0, 224, 80, 54);
                    break;
                }
                if (n14 == 8) {
                    graphics.drawImage(MyCanvas.img[68], n2 - 77, n3 - 54, 80, 234, 80, 54);
                    break;
                }
                break;
            }
            case 11: {
                if (n2 - 96 > 240 || n2 + 48 < 0) {
                    break;
                }
                final int n15 = this.uni_pt3[9][n4][n5];
                if (n15 == 0) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 90, n3 - 21, 0, 204, 100, 21);
                    graphics.drawImage(MyCanvas.img[69], n2 - 96, n3 - 90, 95, 71, 115, 69);
                    break;
                }
                if (n15 == 1) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 88, n3 - 19, 0, 225, 97, 19);
                    graphics.drawImage(MyCanvas.img[69], n2 - 96, n3 - 88, 95, 71, 115, 69);
                    break;
                }
                if (n15 == 2) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 88, n3 - 21, 0, 244, 98, 21);
                    graphics.drawImage(MyCanvas.img[69], n2 - 96, n3 - 90, 95, 71, 115, 69);
                    break;
                }
                if (n15 < 3 || n15 > 7) {
                    break;
                }
                graphics.drawImage(MyCanvas.img[69], n2 - 95, n3 - 71, 145, 0, 89, 71);
                if (n15 == 3 || n15 == 4) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 74, n3 - 110, 0, 0, 95, 101);
                    break;
                }
                if (n15 == 5) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 70, n3 - 103, 0, 101, 95, 103);
                    break;
                }
                /*
                if (n15 == 5) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 75, n3 - 122, 0, 0, 95, 101);
                    break;
                }
                */
                if (n15 == 6) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 74, n3 - 78, 95, 0, 50, 70);
                    graphics.drawImage(MyCanvas.img[69], n2 - 24, n3 - 110, 105, 141, 62, 112);
                    break;
                }
                if (n15 == 7) {
                    graphics.drawImage(MyCanvas.img[69], n2 - 74, n3 - 78, 95, 0, 50, 70);
                    graphics.drawImage(MyCanvas.img[69], n2 - 24, n3 - 110, 105, 141, 62, 112);
                    break;
                }
                break;
            }
            case 12: {
                if (n2 - 71 > 240 || n2 + 38 < 0) {
                    break;
                }
                final int n16 = this.uni_pt3[10][n4][n5];
                if (n16 == 0) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 65, n3 - 83, 0, 0, 67, 83);
                    break;
                }
                if (n16 == 1) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 71, n3 - 80, 67, 0, 73, 80);
                    break;
                }
                if (n16 >= 2 && n16 <= 3) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 48, n3 - 3, 67, 80, 43, 3);
                    graphics.drawImage(MyCanvas.img[70], n2 - 65, n3 - 96 - n16, 146, 0, 67, 93);
                    break;
                }
                if (n16 == 4) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 65, n3 - 89, 0, 83, 67, 89);
                    break;
                }
                if (n16 >= 5 && n16 <= 6) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 60, n3 - 83, 114, 164, 95, 83);
                    if (n16 == 5) {
                        graphics.drawImage(MyCanvas.img[70], n2 - 37, n3 - 66, 146, 93, 75, 24);
                        break;
                    }
                    
                    break;
                }
                else if (n16 >= 7 && n16 <= 8) {
                    graphics.drawImage(MyCanvas.img[70], n2 - 48, n3 - 81, 67, 83, 79, 81);
                    if (n16 == 7) {
                        graphics.drawImage(MyCanvas.img[70], n2 - 36, n3 - 72, 146, 117, 70, 44);
                        break;
                    }
                    break;
                }
                else {
                    if (n16 < 9 || n16 > 10) {
                        break;
                    }
                    graphics.drawImage(MyCanvas.img[70], n2 - 48, n3 - 113, 0, 172, 69, 113);
                    if (n16 == 9) {
                        graphics.drawImage(MyCanvas.img[70], n2 - 16, n3 - 122, 69, 164, 45, 120);
                        break;
                    }
                    break;
                }
            }
            case 13: {
                if (n2 - 71 > 240 || n2 + 24 < 0) {
                    break;
                }
                final int n17 = this.uni_pt3[11][n4][n5];
                if (n17 >= 0 && n17 <= 8) {
                    graphics.drawImage(MyCanvas.img[71], n2 - 68, n3 - 58, n17 % 3 * 77, n17 / 3 * 58, 77, 58);
                    break;
                }
                if (n17 >= 9 && n17 <= 10) {
                    graphics.drawImage(MyCanvas.img[71], n2 - 71, n3 - 56, 0, 174 + (n17 - 9) * 56, 76, 56);
                    break;
                }
                if (n17 == 11) {
                    graphics.drawImage(MyCanvas.img[71], n2 - 61, n3 - 89, 76, 174, 33, 89);
                    graphics.drawImage(MyCanvas.img[71], n2 - 28, n3 - 91, 109, 174, 52, 91);
                    break;
                }
                if (n17 == 12) {
                    graphics.drawImage(MyCanvas.img[71], n2 - 61, n3 - 89, 76, 174, 33, 89);
                    graphics.drawImage(MyCanvas.img[71], n2 - 28, n3 - 89, 161, 174, 39, 89);
                    break;
                }
                break;
            }
            case 14: {
                if (n2 - 73 > 240 || n2 + 40 < 0) {
                    break;
                }
                final int n18 = this.uni_pt3[12][n4][n5];
                if (n18 >= 0 && n18 <= 6) {
                    if (n18 == 0) {
                        graphics.drawImage(MyCanvas.img[72], n2 - 50, n3 - 27, 137, 92, 44, 27);
                    }
                    else {
                        graphics.drawImage(MyCanvas.img[72], n2 - 50, n3 - 27, 181, 92 + (n18 - 1) * 27, 44, 27);
                    }
                    graphics.drawImage(MyCanvas.img[72], n2 - 60, n3 - 102 - this.kuma1[n18], 110, 142, 63, 92);
                    break;
                }
                if (n18 == 7) {
                    graphics.drawImage(MyCanvas.img[72], n2 - 66, n3 - 142, 0, 0, 65, 142);
                    break;
                }
                if (n18 == 8) {
                    graphics.drawImage(MyCanvas.img[72], n2 - 73, n3 - 139, 65, 0, 72, 139);
                    break;
                }
                if (n18 == 9) {
                    graphics.drawImage(MyCanvas.img[72], n2 - 64, n3 - 131, 0, 142, 110, 131);
                    break;
                }
                if (n18 == 10) {
                    graphics.drawImage(MyCanvas.img[72], n2 - 60, n3 - 92, 137, 0, 91, 92);
                    break;
                }
                break;
            }
            case 15: {
                if (n2 - 47 > 240 || n2 + 13 < 0) {
                    break;
                }
                final int n19 = this.uni_pt3[13][n4][n5];
                if (n19 >= 0 && n19 <= 5) {
                    graphics.drawImage(MyCanvas.img[73], n2 - 47, n3 - 28, 0, n19 * 28, 60, 28);
                    break;
                }
                if (n19 >= 6 && n19 <= 8) {
                    graphics.drawImage(MyCanvas.img[73], n2 - 46, n3 - 48, 60, (n19 - 6) * 48, 59, 48);
                    break;
                }
                if (n19 >= 9 && n19 <= 10) {
                    graphics.drawImage(MyCanvas.img[73], n2 - 47, n3 - 24, 60, 144 + (n19 - 9) * 24, 60, 24);
                    break;
                }
                break;
            }
            case 16: {
                if (n2 - 59 > 240 || n2 + 13 < 0) {
                    break;
                }
                final int n20 = this.uni_pt3[14][n4][n5];
                if (n20 == 0) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 43, n3 - 54, 0, 0, 39, 54);
                    break;
                }
                if (n20 == 1 || n20 == 2) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 43, n3 - 44, 39 + (n20 - 1) * 39, 0, 39, 44);
                    break;
                }
                if (n20 == 3) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 48, n3 - 58, 118, 0, 44, 58);
                    break;
                }
                if (n20 == 4) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 42, n3 - 3, 55, 130, 37, 3);
                    graphics.drawImage(MyCanvas.img[74], n2 - 48, n3 - 61, 162, 0, 51, 50);
                    break;
                }
                if (n20 == 5) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 41, n3 - 55, 171, 50, 42, 55);
                    break;
                }
                if (n20 < 6 || n20 > 11) {
                    break;
                }
                graphics.drawImage(MyCanvas.img[74], n2 - 42, n3 - 3, 55, 130, 37, 3);
                if (n20 == 6) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 59, n3 - 62, 0, 54, 55, 45);
                    break;
                }
                if (n20 == 7) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 59, n3 - 75, 118, 58, 52, 51);
                    break;
                }
                if (n20 == 8) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 59, n3 - 77, 118, 58, 52, 51);
                    break;
                }
                if (n20 == 9) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 41, n3 - 70, 0, 99, 36, 42);
                    break;
                }
                if (n20 == 10) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 50, n3 - 75, 55, 44, 63, 47);
                    break;
                }
                if (n20 == 11) {
                    graphics.drawImage(MyCanvas.img[74], n2 - 50, n3 - 68, 55, 91, 63, 39);
                    break;
                }
                break;
            }
            case 17: {
                if (n2 - 53 > 240 || n2 + 6 < 0) {
                    break;
                }
                final int n21 = this.uni_pt3[15][n4][n5];
                if (n21 == 0) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 40, n3 - 30, 0, 0, 39, 30);
                    break;
                }
                if (n21 == 1) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 44, n3 - 28, 39, 0, 41, 28);
                    break;
                }
                if (n21 == 2) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 50, n3 - 31, 80, 0, 47, 31);
                    break;
                }
                if (n21 == 3) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 53, n3 - 33, 127, 0, 53, 33);
                    break;
                }
                if (n21 == 4) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 53, n3 - 34, 180, 0, 51, 34);
                    break;
                }
                if (n21 == 5 || n21 == 6) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 51, n3 - 62, 53 + (n21 - 5) * 50, 33, 50, 62);
                    break;
                }
                if (n21 == 7) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 47, n3 - 65, 0, 30, 53, 65);
                    break;
                }
                if (n21 == 8) {
                    graphics.drawImage(MyCanvas.img[75], n2 - 46, n3 - 44, 153, 34, 49, 44);
                    break;
                }
                break;
            }
            case 18: {
                if (n2 - 73 > 240 || n2 + 40 < 0) {
                    break;
                }
                final int n22 = this.uni_pt3[16][n4][n5];
                if (n22 >= 0 && n22 <= 6) {
                    if (n22 == 0) {
                        graphics.drawImage(MyCanvas.img[76], n2 - 50, n3 - 27, 137, 92, 44, 27);
                    }
                    else {
                        graphics.drawImage(MyCanvas.img[76], n2 - 50, n3 - 27, 181, 92 + (n22 - 1) * 27, 44, 27);
                    }
                    graphics.drawImage(MyCanvas.img[76], n2 - 60, n3 - 102 - this.kuma1[n22], 110, 142, 63, 92);
                    break;
                }
                if (n22 == 7) {
                    graphics.drawImage(MyCanvas.img[76], n2 - 66, n3 - 142, 0, 0, 65, 142);
                    break;
                }
                if (n22 == 8) {
                    graphics.drawImage(MyCanvas.img[76], n2 - 73, n3 - 139, 65, 0, 72, 139);
                    break;
                }
                if (n22 == 9) {
                    graphics.drawImage(MyCanvas.img[76], n2 - 64, n3 - 131, 0, 142, 110, 131);
                    break;
                }
                if (n22 == 10) {
                    graphics.drawImage(MyCanvas.img[76], n2 - 60, n3 - 92, 137, 0, 91, 92);
                    break;
                }
                break;
            }
            case 19: {
                if (n2 - 89 > 240 || n2 + 12 < 0) {
                    break;
                }
                final int n23 = this.uni_pt3[17][n4][n5];
                graphics.drawImage(MyCanvas.img[77], n2 - 59, n3 - 3, 90, 209, 53, 3);
                if (n23 >= 0 && n23 <= 8) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 77, n3 - 105 - n23, 0, 0, 84, 90);
                    break;
                }
                if (n23 == 9) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 83, n3 - 123, 0, 90, 89, 111);
                    break;
                }
                if (n23 == 10) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 86, n3 - 127, 0, 201, 90, 116);
                    break;
                }
                if (n23 == 11) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 88, n3 - 129, 0, 201, 90, 116);
                    break;
                }
                if (n23 == 12) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 89, n3 - 130, 0, 201, 90, 116);
                    break;
                }
                if (n23 == 13) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 82, n3 - 121, 0, 90, 89, 111);
                    break;
                }
                if (n23 == 14) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 74, n3 - 112, 89, 0, 86, 111);
                    break;
                }
                if (n23 == 15) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 72, n3 - 105, 90, 111, 83, 98);
                    break;
                }
                if (n23 == 16) {
                    graphics.drawImage(MyCanvas.img[77], n2 - 71, n3 - 104, 90, 111, 83, 98);
                    break;
                }
                break;
            }
            case 20: {
                if (n2 - 89 > 240 || n2 + 12 < 0) {
                    break;
                }
                final int n24 = this.uni_pt3[18][n4][n5];
                graphics.drawImage(MyCanvas.img[78], n2 - 59, n3 - 3, 90, 209, 53, 3);
                if (n24 >= 0 && n24 <= 8) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 77, n3 - 105 - n24, 0, 0, 84, 90);
                    break;
                }
                if (n24 == 9) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 83, n3 - 123, 0, 90, 89, 111);
                    break;
                }
                if (n24 == 10) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 86, n3 - 127, 0, 201, 90, 116);
                    break;
                }
                if (n24 == 11) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 88, n3 - 129, 0, 201, 90, 116);
                    break;
                }
                if (n24 == 12) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 89, n3 - 130, 0, 201, 90, 116);
                    break;
                }
                if (n24 == 13) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 82, n3 - 121, 0, 90, 89, 111);
                    break;
                }
                if (n24 == 14) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 74, n3 - 112, 89, 0, 86, 111);
                    break;
                }
                if (n24 == 15) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 72, n3 - 105, 90, 111, 83, 98);
                    break;
                }
                if (n24 == 16) {
                    graphics.drawImage(MyCanvas.img[78], n2 - 71, n3 - 104, 90, 111, 83, 98);
                    break;
                }
                break;
            }
            case 21: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n25 = this.uni_pt3[19][n4][n5];
                    graphics.drawImage(MyCanvas.img[79], n2 - 36, n3 - 40, n25 % 6 * 36, n25 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 22: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n26 = this.uni_pt3[20][n4][n5];
                    graphics.drawImage(MyCanvas.img[80], n2 - 36, n3 - 40, n26 % 6 * 36, n26 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 23: {
                if (n2 - 53 > 240 || n2 + 78 < 0) {
                    break;
                }
                final int n27 = this.uni_pt3[21][n4][n5];
                if (n27 >= 0 && n27 <= 5) {
                    graphics.drawImage(MyCanvas.img[81], n2 - 23, n3 - 25, 0, n27 * 25, 17, 25);
                    graphics.drawImage(MyCanvas.img[81], n2 - 47, n3 - this.kan1[n27], 17, 0, 75, 75);
                    break;
                }
                if (n27 == 6) {
                    graphics.drawImage(MyCanvas.img[81], n2 - 53, n3 - 99, 17, 75, 74, 99);
                    break;
                }
                if (n27 == 7) {
                    graphics.drawImage(MyCanvas.img[81], n2 - 23, n3 - 99, 92, 0, 101, 99);
                    break;
                }
                if (n27 == 8) {
                    graphics.drawImage(MyCanvas.img[81], n2 - 23, n3 - 99, 92, 99, 101, 99);
                    break;
                }
                break;
            }
            case 24: {
                if (n2 - 76 > 240 || n2 + 36 < 0) {
                    break;
                }
                final int n28 = this.uni_pt3[22][n4][n5];
                if (n28 >= 0 && n28 <= 4) {
                    graphics.drawImage(MyCanvas.img[82], n2 - 36, n3 - 3, 96, 267, 31, 4);
                    graphics.drawImage(MyCanvas.img[82], n2 - this.mos2[n28 * 2], n3 - this.mos2[n28 * 2 + 1], this.mos1[n28 * 4], this.mos1[n28 * 4 + 1], this.mos1[n28 * 4 + 2], this.mos1[n28 * 4 + 3]);
                    break;
                }
                if (n28 >= 5 && n28 <= 30) {
                    graphics.drawImage(MyCanvas.img[82], n2 - 36, n3 - 3, 96, 267, 31, 4);
                    final int n29 = n28 % 5;
                    final int n30 = (n28 - 5) / 5;
                    graphics.drawImage(MyCanvas.img[82], n2 - this.mos3[n29 * 2] + this.mos4[n30], n3 - this.mos3[n29 * 2 + 1] + this.mos4[n30], this.mos1[n29 * 4], this.mos1[n29 * 4 + 1], this.mos1[n29 * 4 + 2], this.mos1[n29 * 4 + 3]);
                    break;
                }
                if (n28 == 31) {
                    graphics.drawImage(MyCanvas.img[82], n2 - 59, n3 - 118, 0, 181, 95, 118);
                    break;
                }
                if (n28 >= 32 && n28 <= 34) {
                    final int n31 = n28 % 5;
                    graphics.drawImage(MyCanvas.img[82], n2 - 36, n3 - 3, 96, 267, 31, 4);
                    graphics.drawImage(MyCanvas.img[82], n2 - this.mos5[(n28 - 32) * 2], n3 - this.mos5[(n28 - 32) * 2 + 1], this.mos1[n31 * 4], this.mos1[n31 * 4 + 1], this.mos1[n31 * 4 + 2], this.mos1[n31 * 4 + 3]);
                    break;
                }
                if (n28 == 35) {
                    graphics.drawImage(MyCanvas.img[82], n2 - 36, n3 - 3, 96, 267, 31, 4);
                    graphics.drawImage(MyCanvas.img[82], n2 - 44, n3 - 94, 95, 177, 74, 90);
                    break;
                }
                break;
            }
            case 25: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n32 = this.uni_pt3[23][n4][n5];
                    graphics.drawImage(MyCanvas.img[83], n2 - 36, n3 - 40, n32 % 6 * 36, n32 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 26: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n33 = this.uni_pt3[24][n4][n5];
                    graphics.drawImage(MyCanvas.img[84], n2 - 36, n3 - 40, n33 % 6 * 36, n33 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 27: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n34 = this.uni_pt3[25][n4][n5];
                    graphics.drawImage(MyCanvas.img[85], n2 - 36, n3 - 40, n34 % 6 * 36, n34 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 28: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n35 = this.uni_pt3[26][n4][n5];
                    graphics.drawImage(MyCanvas.img[86], n2 - 36, n3 - 40, n35 % 6 * 36, n35 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 29: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n36 = this.uni_pt3[27][n4][n5];
                    graphics.drawImage(MyCanvas.img[87], n2 - 36, n3 - 40, n36 % 6 * 36, n36 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 30: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n37 = this.uni_pt3[28][n4][n5];
                    graphics.drawImage(MyCanvas.img[88], n2 - 36, n3 - 40, n37 % 6 * 36, n37 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
            case 31: {
                if (n2 - 36 <= 240 && n2 >= 0) {
                    final int n38 = this.uni_pt3[29][n4][n5];
                    graphics.drawImage(MyCanvas.img[89], n2 - 36, n3 - 40, n38 % 6 * 36, n38 / 6 * 40, 36, 40);
                    break;
                }
                break;
            }
        }
    }
    
    public void sen1(final Graphics graphics) {
        this.box(graphics, 20, 109, 200, 22);
        if (this.p_flg[1] % 2 == 0) {
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
        }
        else {
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 0));
        }
        MyCanvas.sivar[12] = 4;
        this.drawString(graphics, "\u6575\u306e\u57ce\u3092\u653b\u3081\u843d\u3068\u3059\u306b\u3083\uff01\uff01", 120, 114);
    }
    
    public void sen2(final Graphics graphics) {
        if (this.p_flg[15] >= 1) {
            int n = this.p_flg[16];
            if (this.p_flg[15] != 1) {
                n = this.s_tbl1.length - 1;
            }
            else if (n > this.s_tbl1.length - 1) {
                n = this.s_tbl1.length - 1;
            }
            graphics.drawImage(MyCanvas.img[191], 26 - this.s_tbl1[n], 76);
        }
        if (this.p_flg[15] >= 2) {
            int n2 = this.p_flg[16];
            if (this.p_flg[15] != 2) {
                n2 = this.s_tbl1.length - 1;
            }
            else if (n2 > this.s_tbl1.length - 1) {
                n2 = this.s_tbl1.length - 1;
            }
            this.setQuad2(MyCanvas.pri[0], 0, 0 - this.s_tbl1[n2], 126, 1000, 240, 22);
            MyCanvas.pri[0].getColorArray()[0] = 11711154;
            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
            MyCanvas.g3d.flush();
            int i = this.p_flg[17];
            int n3 = 1;
            for (int n4 = 10; i >= n4; n4 *= 10) {
                ++n3;
            }
            final int n5 = (240 - (44 + 11 * n3 + 2 + 4 + 39)) / 2;
            graphics.drawImage(MyCanvas.img[193], n5 - this.s_tbl1[n2], 130);
            int n6 = n5 + 40 + 4 + 11 * n3 + 2 - 13 - this.s_tbl1[n2];
            do {
                graphics.drawImage(MyCanvas.img[261], n6, 127, i % 10 * 13, 0, 13, 19);
                i /= 10;
                n6 -= 11;
            } while (i > 0);
            graphics.drawImage(MyCanvas.img[194], n5 + 40 + 4 + 11 * n3 + 2 + 4 - this.s_tbl1[n2], 131);
        }
        if (this.p_flg[15] == 4) {
            this.box(graphics, 32, 163, 176, 37);
            final String str = "\u304a\u5b9d ";
            final String string = this.ta5[this.p_flg[18] - 1] + this.ta4[this.p_flg[20]];
            final int stringWidth = MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str);
            final int n7 = (240 - MyCanvas.font[MyCanvas.sivar[11]].stringWidth(str + string)) / 2;
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 0));
            MyCanvas.sivar[12] = 5;
            this.drawString(graphics, str, n7, 168);
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
            MyCanvas.sivar[12] = 5;
            this.drawString(graphics, string, stringWidth + n7, 168);
            if (this.p_flg[16] % 2 == 0) {
                graphics.setColor(Graphics.getColorOfRGB(255, 255, 0));
            }
            else {
                graphics.setColor(Graphics.getColorOfRGB(255, 0, 255));
            }
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u30b2\u30c3\u30c8\uff01!", 120, 183);
        }
        if (this.p_flg[15] == 5) {
            this.box(graphics, 32, 163, 176, 37);
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, this.ta6[this.p_flg[19] * 3], 120, 168);
            if (this.p_flg[16] % 2 == 0) {
                graphics.setColor(Graphics.getColorOfRGB(255, 255, 0));
            }
            else {
                graphics.setColor(Graphics.getColorOfRGB(255, 0, 255));
            }
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u767a\u52d5\uff01!", 120, 183);
        }
    }
    
    public void sen3(final Graphics graphics) {
        if (this.p_flg[15] >= 2) {
            int n = 40;
            if (this.p_flg[15] == 2) {
                n = this.p_flg[16];
            }
            if (n > 40) {
                n = 40;
            }
            final int n2 = 255 * n / 40;
            this.setQuad2(MyCanvas.pri[0], 0, 0, 0, 1000, 240, 240);
            MyCanvas.pri[0].getColorArray()[0] = (n2 << 16 | n2 << 8 | n2);
            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
            MyCanvas.g3d.flush();
        }
        if (this.p_flg[15] >= 1) {
            int n3 = this.p_flg[16];
            if (this.p_flg[15] != 1) {
                n3 = this.s_tbl3.length - 1;
            }
            else if (n3 > this.s_tbl3.length - 1) {
                n3 = this.s_tbl1.length - 1;
            }
            graphics.drawImage(MyCanvas.img[192], 59, this.s_tbl3[n3]);
        }
        if (this.p_flg[15] == 3 && this.p_flg[24] == 1) {
            this.box(graphics, 32, 174, 176, 37);
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u30af\u30ea\u30a2\u6e08\u307f\u306e\u30b9\u30c6\u30fc\u30b8\u3067", 120, 179);
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u7d4c\u9a13\u5024\u3092\u8caf\u3081\u3066\u518d\u6311\u6226\u306b\u3083\uff01", 120, 194);
        }
    }
    
    public void sen4(final Graphics graphics) {
        if (this.p_flg[15] >= 1) {
            int n = this.p_flg[16];
            if (this.p_flg[15] != 1) {
                n = this.s_tbl1.length - 1;
            }
            else if (n > this.s_tbl1.length - 1) {
                n = this.s_tbl1.length - 1;
            }
            graphics.drawImage(MyCanvas.img[191], 26 - this.s_tbl1[n], 76);
        }
        if (this.p_flg[15] >= 2) {
            int n2 = this.p_flg[16];
            if (this.p_flg[15] != 2) {
                n2 = this.s_tbl1.length - 1;
            }
            else if (n2 > this.s_tbl1.length - 1) {
                n2 = this.s_tbl1.length - 1;
            }
            this.setQuad2(MyCanvas.pri[0], 0, 0 - this.s_tbl1[n2], 126, 1000, 240, 22);
            MyCanvas.pri[0].getColorArray()[0] = 11711154;
            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
            MyCanvas.g3d.flush();
            int i = this.p_flg[22];
            int n3 = 1;
            for (int n4 = 10; i >= n4; n4 *= 10) {
                ++n3;
            }
            final int n5 = (240 - (49 + 11 * n3 + 2 + 4 + 16)) / 2;
            graphics.drawImage(MyCanvas.img[257], n5 - this.s_tbl1[n2], 130);
            int n6 = n5 + 45 + 4 + 11 * n3 + 2 - 13 - this.s_tbl1[n2];
            do {
                graphics.drawImage(MyCanvas.img[27], n6, 127, i % 10 * 13, 0, 13, 19);
                i /= 10;
                n6 -= 11;
            } while (i > 0);
            graphics.drawImage(MyCanvas.img[258], n5 + 40 + 4 + 11 * n3 + 2 + 4 - this.s_tbl1[n2], 129);
        }
        if (this.p_flg[15] >= 3 && this.p_flg[23] == 1) {
            graphics.drawImage(MyCanvas.img[259], 85, 150, 0, 13 * (this.p_flg[1] % 2), 71, 13);
        }
    }
    
    public void sen5(final Graphics graphics) {
        if (this.p_flg[15] >= 1) {
            int n = this.p_flg[16];
            if (this.p_flg[15] != 1) {
                n = this.s_tbl3.length - 1;
            }
            else if (n > this.s_tbl3.length - 1) {
                n = this.s_tbl1.length - 1;
            }
            graphics.drawImage(MyCanvas.img[192], 59, this.s_tbl3[n] - 20);
        }
        if (this.p_flg[15] >= 2) {
            this.setQuad2(MyCanvas.pri[0], 0, 0, 126, 1000, 240, 22);
            MyCanvas.pri[0].getColorArray()[0] = 11711154;
            MyCanvas.g3d.renderPrimitives(MyCanvas.pri[0], 96);
            MyCanvas.g3d.flush();
            int i = this.p_flg[22];
            int n2 = 1;
            for (int n3 = 10; i >= n3; n3 *= 10) {
                ++n2;
            }
            final int n4 = (240 - (49 + 11 * n2 + 2 + 4 + 16)) / 2;
            graphics.drawImage(MyCanvas.img[257], n4, 130);
            int n5 = n4 + 45 + 4 + 11 * n2 + 2 - 13;
            do {
                graphics.drawImage(MyCanvas.img[27], n5, 127, i % 10 * 13, 0, 13, 19);
                i /= 10;
                n5 -= 11;
            } while (i > 0);
            graphics.drawImage(MyCanvas.img[258], n4 + 40 + 4 + 11 * n2 + 2 + 4, 129);
        }
        if (this.p_flg[15] >= 2 && this.p_flg[23] == 1) {
            graphics.drawImage(MyCanvas.img[259], 85, 150, 0, 13 * (this.p_flg[1] % 2), 71, 13);
        }
    }
    
    public void takara_s() {
        for (int i = 0; i < this.ta1.length; ++i) {
            this.p_flg3[i] = 0;
            int n = 0;
            for (int j = 0; j < this.ta1[i]; ++j) {
                if (this.save6[this.ta2[i][j]] <= 0) {
                    n = 0;
                    break;
                }
                n += this.save6[this.ta2[i][j]];
            }
            if (n != 0) {
                this.p_flg3[i] = 100 * n / (this.ta1[i] * 3);
            }
        }
    }
    
    public void tizu_s() {
        if (this.p_flg[15] == 0) {
            final int n = this.p_flg[16];
            this.p_flg[11] = 94 - (this.tizu1[n * 6 + 4] + this.tizu1[n * 6 + 2] / 2);
            this.p_flg[12] = 112 - (this.tizu1[n * 6 + 5] + this.tizu1[n * 6 + 3] / 2);
            this.p_flg[13] = this.p_flg[9];
            this.p_flg[14] = this.p_flg[10];
        }
        final int[] p_flg = this.p_flg;
        final int n2 = 15;
        ++p_flg[n2];
        if (this.p_flg[15] >= this.tizu4.length - 1) {
            this.p_flg[15] = this.tizu4.length - 1;
        }
        this.p_flg[9] = this.p_flg[13] + (this.p_flg[11] - this.p_flg[13]) * this.tizu4[this.p_flg[15]] / 100;
        this.p_flg[10] = this.p_flg[14] + (this.p_flg[12] - this.p_flg[14]) * this.tizu4[this.p_flg[15]] / 100;
    }
    
    public void uni_a1(final int n) {
        int n2;
        if (this.uni[0][n][6] < 9) {
            n2 = this.uni_pt1[this.uni[0][n][0] - 2][this.uni[0][n][1]].length;
        }
        else {
            n2 = this.uni_pt2[this.uni[0][n][0] - 2][this.uni[0][n][1]].length;
        }
        this.uni[0][n][2] = (this.uni[0][n][2] + 1) % n2;
    }
    
    public void uni_a2(final int n) {
        this.uni[1][n][2] = (this.uni[1][n][2] + 1) % this.uni_pt3[this.uni[1][n][0] - 2][this.uni[1][n][1]].length;
    }
    
    public void box(final Graphics graphics, final int n, final int n2, final int n3, final int n4) {
        graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
        graphics.fillRect(n - 7, n2 - 7, n3 + 14, n4 + 14);
        graphics.setColor(Graphics.getColorOfRGB(255, 0, 244));
        graphics.fillRect(n - 5, n2 - 5, n3 + 10, n4 + 10);
        graphics.setColor(Graphics.getColorOfRGB(73, 9, 77));
        graphics.fillRect(n - 1, n2 - 1, n3 + 2, n4 + 2);
        graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
        graphics.drawRect(n, n2, n3 - 1, n4 - 1);
        graphics.drawImage(MyCanvas.wakuimg, n - 7 - 5, n2 - 7 - 3, 0, 0, 18, 19);
        graphics.drawImage(MyCanvas.wakuimg, n + n3 - 6, n2 - 7 - 3, 18, 0, 18, 19);
        graphics.drawImage(MyCanvas.wakuimg, n - 7 - 5, n2 + n4 - 9, 36, 0, 18, 19);
        graphics.drawImage(MyCanvas.wakuimg, n + n3 - 6, n2 + n4 - 9, 54, 0, 18, 19);
    }
    
    public void kurokane(final Graphics graphics, final int n, final int n2, final int n3, final int n4, final int n5) {
        int i = n;
        int n6 = n4;
        if (n3 == 1) {
            graphics.drawImage(MyCanvas.img[26], n6, n5, 90, 26, 11, 13);
            n6 -= 7;
        }
        do {
            graphics.drawImage(MyCanvas.img[26], n6, n5, i % 10 * 9, 26, 9, 13);
            i /= 10;
            n6 -= 6;
        } while (i > 0);
        int j = n;
        int n7 = n4;
        if (n3 == 1) {
            graphics.drawImage(MyCanvas.img[26], n7, n5, 90, n2 * 13, 11, 13);
            n7 -= 7;
        }
        do {
            graphics.drawImage(MyCanvas.img[26], n7, n5, j % 10 * 9, n2 * 13, 9, 13);
            j /= 10;
            n7 -= 6;
        } while (j > 0);
    }
    
    public int syatei(final int n, final int n2, final int n3) {
        final int n4 = (n == 0) ? 1 : 0;
        int n5;
        int n6;
        if (n == 0) {
            n5 = this.uni[0][n2][3] - this.uni[0][n2][13];
            n6 = this.uni[0][n2][3];
        }
        else {
            n5 = this.uni[1][n2][3];
            n6 = this.uni[1][n2][3] + this.uni[1][n2][13];
        }
        if (this.uni[n4][n3][0] > 0 && this.uni[n4][n3][1] <= 2) {
            int n7;
            int n8;
            if (n == 0) {
                n7 = this.uni[n4][n3][3] - this.uni[n4][n3][14];
                n8 = this.uni[n4][n3][3] - this.uni[n4][n3][15];
            }
            else {
                n7 = this.uni[n4][n3][3] + this.uni[n4][n3][15];
                n8 = this.uni[n4][n3][3] + this.uni[n4][n3][14];
            }
            if (n5 <= n7 && n6 >= n8) {
                return 1;
            }
        }
        return 0;
    }
    
    public int uni_s(final int n, final int n2, final int n3, final int n4, final int n5) {
        for (int i = 1; i < this.uni[n].length; ++i) {
            if (this.uni[n][i][0] == 0) {
                this.uni[n][i][0] = n2;
                this.uni[n][i][1] = 0;
                this.uni[n][i][2] = 0;
                this.uni[n][i][4] = 1960;
                this.uni[n][i][5] = n4;
                int n6 = n5 - n4 + 1;
                if (n6 <= 0) {
                    n6 = 1;
                }
                final int[] array = this.uni[n][i];
                final int n7 = 5;
                array[n7] += this.random(n6);
                this.uni[n][i][6] = n3;
                this.uni[n][i][18] = 0;
                this.uni[n][i][19] = 0;
                this.uni[n][i][22] = 0;
                this.uni[n][i][23] = 0;
                if (n == 0) {
                    this.uni[n][i][3] = this.dat[0] - 700;
                    this.uni[n][i][7] = this.uni_dat1[n2][n3][0];
                    final int[] array2 = this.uni[n][i];
                    final int n8 = 7;
                    array2[n8] += this.uni[n][i][7] * (this.ta7[6] * this.p_flg3[6] / 100) / 100;
                    this.uni[n][i][8] = this.uni[n][i][7];
                    this.uni[n][i][9] = this.uni_dat1[n2][n3][1];
                    this.uni[n][i][10] = this.uni_dat1[n2][n3][2];
                    this.uni[n][i][11] = this.uni_dat1[n2][n3][3];
                    final int[] array3 = this.uni[n][i];
                    final int n9 = 11;
                    array3[n9] += this.uni[n][i][11] * (this.ta7[7] * this.p_flg3[7] / 100) / 100;
                    this.uni[n][i][12] = this.uni_dat1[n2][n3][4];
                    this.uni[n][i][13] = this.uni_dat1[n2][n3][5];
                    this.uni[n][i][14] = this.uni_dat1[n2][n3][8];
                    this.uni[n][i][15] = this.uni_dat1[n2][n3][9];
                    this.uni[n][i][16] = this.uni_dat1[n2][n3][10];
                    this.uni[n][i][17] = this.uni_dat1[n2][n3][11];
                    this.uni[n][i][20] = this.uni_dat1[n2][n3][12];
                    this.uni[n][i][21] = this.uni_dat1[n2][n3][13];
                }
                else {
                    this.uni[n][i][3] = 700;
                    this.uni[n][i][7] = this.uni_dat2[n2][0];
                    this.uni[n][i][8] = this.uni[n][i][7];
                    this.uni[n][i][9] = this.uni_dat2[n2][1];
                    this.uni[n][i][10] = this.uni_dat2[n2][2];
                    this.uni[n][i][11] = this.uni_dat2[n2][3];
                    this.uni[n][i][12] = this.uni_dat2[n2][4];
                    this.uni[n][i][13] = this.uni_dat2[n2][5];
                    this.uni[n][i][14] = this.uni_dat2[n2][7];
                    this.uni[n][i][15] = this.uni_dat2[n2][8];
                    this.uni[n][i][16] = this.uni_dat2[n2][9];
                    this.uni[n][i][17] = this.uni_dat2[n2][10];
                    this.uni[n][i][20] = this.uni_dat2[n2][11];
                    this.uni[n][i][21] = this.uni_dat2[n2][12];
                }
                return i;
            }
        }
        return -1;
    }
    
    public void st_s() {
        this.stage_read(this.p_flg[0]);
        this.p_flg[20] = this.tizu3[this.p_flg[0]];
        this.p_flg[5] = this.dat[0] - 2400;
        this.p_flg[10] = 0;
        for (int i = 0; i < this.p_flg2.length; ++i) {
            for (int j = 0; j < this.p_flg2[i].length; ++j) {
                this.p_flg2[i][j] = 0;
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.p_flg2[k + 2][0] = this.save3[13 + k];
        }
        this.p_flg[11] = this.save3[5];
        this.p_flg[6] = this.nyan8[this.p_flg[11]];
        this.p_flg[7] = this.nyan9[this.save3[6]];
        this.p_flg2[1][0] = 0;
        this.p_flg2[1][1] = 0;
        this.p_flg2[1][2] = 0;
        this.p_flg[9] = this.p_flg[7] * (10 + this.p_flg2[1][0] * 5) / 10;
        final int[] p_flg = this.p_flg;
        final int n = 9;
        p_flg[n] += this.ta7[1] * this.p_flg3[1] / 100;
        this.p_flg[8] = this.p_flg[6] * (10 + this.p_flg2[1][0]) / 10;
        final int[] p_flg2 = this.p_flg;
        final int n2 = 8;
        p_flg2[n2] += this.ta7[0] * this.p_flg3[0] / 100;
        for (int l = 0; l < this.uni.length; ++l) {
            for (int n3 = 0; n3 < this.uni[l].length; ++n3) {
                for (int n4 = 0; n4 < this.uni[l][n3].length; ++n4) {
                    this.uni[l][n3][n4] = 0;
                }
            }
        }
        this.uni[0][0][0] = 1;
        this.uni[0][0][1] = 0;
        this.uni[0][0][2] = 0;
        this.uni[0][0][3] = this.dat[0] - 800;
        this.uni[0][0][4] = 630;
        this.uni[0][0][5] = 0;
        this.uni[0][0][6] = this.nyan1[this.save3[3]];
        this.uni[0][0][7] = this.nyan7[this.save3[7]];
        final int[] array = this.uni[0][0];
        final int n5 = 7;
        array[n5] += this.ta7[4] * this.p_flg3[4] / 100;
        this.uni[0][0][8] = this.uni[0][0][7];
        this.uni[0][0][9] = 0;
        this.uni[0][0][10] = 0;
        this.uni[0][0][11] = this.nyan2[this.save3[4]] + this.nyan6[this.save3[2]];
        final int[] array2 = this.uni[0][0];
        final int n6 = 11;
        array2[n6] -= this.ta7[9] * this.p_flg3[9] / 100;
        this.uni[0][0][12] = this.uni[0][0][11];
        this.uni[0][0][13] = 0;
        this.uni[0][0][14] = 0;
        this.uni[0][0][15] = 600;
        this.uni[0][0][16] = this.nyan4[this.save3[2]];
        final int[] array3 = this.uni[0][0];
        final int n7 = 16;
        array3[n7] += this.ta7[8] * this.p_flg3[8] / 100;
        this.uni[1][0][0] = 1;
        this.uni[1][0][1] = 0;
        this.uni[1][0][2] = 0;
        this.uni[1][0][3] = 800;
        this.uni[1][0][4] = 530;
        this.uni[1][0][5] = 0;
        this.uni[1][0][7] = this.dat[1];
        this.uni[1][0][8] = this.uni[1][0][7];
        this.uni[1][0][14] = 0;
        this.uni[1][0][15] = 600;
        this.t_flg = this.random(this.dat[3] - this.dat[2] + 1) + this.dat[2];
        for (int n8 = 0; n8 < this.dat2.length; ++n8) {
            if (this.dat2[n8][0] != 0) {
                this.t_flg2[n8][0] = this.dat2[n8][2];
            }
            else {
                this.t_flg2[n8][0] = 0;
            }
            this.t_flg2[n8][1] = 0;
        }
        for (int n9 = 0; n9 < this.ef1.length; ++n9) {
            for (int n10 = 0; n10 < this.ef1[n9].length; ++n10) {
                for (int n11 = 0; n11 < this.ef1[n9][n10].length; ++n11) {
                    this.ef1[n9][n10][n11] = 0;
                }
            }
        }
        for (int n12 = 0; n12 < this.ef2.length; ++n12) {
            for (int n13 = 0; n13 < this.ef2[n12].length; ++n13) {
                this.ef2[n12][n13] = 0;
            }
        }
        for (int n14 = 0; n14 < this.c_dai.length; ++n14) {
            this.c_dai[n14] = 0;
        }
        for (int n15 = 0; n15 < 9; ++n15) {
            if (this.p_flg2[n15 + 2][0] == 10) {
                this.g_load(14 + n15);
                this.g_load(42 + n15);
            }
            else {
                this.g_load(4 + n15);
                this.g_load(32 + n15);
            }
        }
        this.g_load(this.dat[4]);
        this.g_load(91 + this.p_flg[20]);
        this.g_load(140 + this.p_flg[20]);
        for (int n16 = 0; n16 < this.dat2.length; ++n16) {
            if (this.dat2[n16][0] >= 2) {
                this.g_load(60 + this.dat2[n16][0] - 2);
            }
        }
        if (this.dat[4] == 2) {
            for (int n17 = 0; n17 < this.hosi.length; ++n17) {
                this.hosi[n17][0] = (n17 * 48 + this.random(48)) % 240;
                this.hosi[n17][1] = 10 + this.random(110);
                this.hosi[n17][2] = this.random(200);
                this.hosi[n17][3] = 5 + this.random(21);
            }
        }
        else if (this.dat[4] == 3) {
            for (int n18 = 0; n18 < this.yuki.length; ++n18) {
                this.yuki[n18][0] = (n18 * 56 + this.random(56)) % 280 * 100;
                this.yuki[n18][1] = (n18 * 56 + this.random(56)) % 280 * 100 - 2000;
                this.yuki[n18][2] = 374 - this.random(100);
                this.yuki[n18][3] = 200 + this.random(600);
            }
        }
    }
    
    public void stage_read(final int n) {
        final String[] array = new String[21];
        final byte[] array2 = new byte[1000];
        int read = 0;
        String str;
        if (n < 10) {
            str = "stage0" + Integer.toString(n) + ".csv";
        }
        else {
            str = "stage" + Integer.toString(n) + ".csv";
        }
        try {
            final InputStream openInputStream = Connector.openInputStream("resource:///" + str);
            read = openInputStream.read(array2);
            openInputStream.close();
        }
        catch (final ConnectionException ex) {}
        catch (final IOException ex2) {}
        int offset = 0;
        for (int i = 0; i < array.length; ++i) {
            int length;
            for (length = 0; array2[offset + length] != 13 && offset + length < read; ++length) {}
            array[i] = new String(array2, offset, length);
            offset = offset + length + 2;
        }
        int n2 = 0;
        for (int j = 0; j < this.dat.length; ++j) {
            this.dat[j] = 0;
            final int index = array[0].indexOf(44, n2);
            if (index > n2) {
                this.dat[j] = Integer.parseInt(array[0].substring(n2, index));
            }
            n2 = index + 1;
        }
        for (int k = 0; k < this.dat2.length; ++k) {
            int n3 = 0;
            for (int l = 0; l < this.dat2[k].length; ++l) {
                this.dat2[k][l] = 0;
                final int index2 = array[1 + k].indexOf(44, n3);
                if (index2 > n3) {
                    this.dat2[k][l] = Integer.parseInt(array[1 + k].substring(n3, index2));
                }
                n3 = index2 + 1;
            }
        }
    }
    
    public void unit_read(final int n) {
        final String[] array = new String[this.uni_dat1[n + 2].length];
        final byte[] array2 = new byte[1000];
        int read = 0;
        final String string = "unit0" + Integer.toString(n + 1) + ".csv";
        try {
            final InputStream openInputStream = Connector.openInputStream("resource:///" + string);
            read = openInputStream.read(array2);
            openInputStream.close();
        }
        catch (final ConnectionException ex) {}
        catch (final IOException ex2) {}
        int offset = 0;
        for (int i = 0; i < array.length; ++i) {
            int length;
            for (length = 0; array2[offset + length] != 13 && offset + length < read; ++length) {}
            array[i] = new String(array2, offset, length);
            offset = offset + length + 2;
        }
        for (int j = 0; j < this.uni_dat1[n + 2].length; ++j) {
            int n2 = 0;
            for (int k = 0; k < this.uni_dat1[n + 2][j].length; ++k) {
                this.uni_dat1[n + 2][j][k] = 0;
                final int index = array[j].indexOf(44, n2);
                if (index > n2) {
                    this.uni_dat1[n + 2][j][k] = Integer.parseInt(array[j].substring(n2, index));
                }
                n2 = index + 1;
            }
        }
        for (int l = 0; l < this.uni_dat1[n + 2].length; ++l) {
            final int[] array3 = this.uni_dat1[n + 2][l];
            final int n3 = 6;
            array3[n3] *= 100;
        }
    }
    
    public void t_unit_read() {
        final String[] array = new String[this.uni_dat2.length];
        final byte[] array2 = new byte[2000];
        int read = 0;
        final String str = "t_unit.csv";
        try {
            final InputStream openInputStream = Connector.openInputStream("resource:///" + str);
            read = openInputStream.read(array2);
            openInputStream.close();
        }
        catch (final ConnectionException ex) {}
        catch (final IOException ex2) {}
        int offset = 0;
        for (int i = 0; i < array.length; ++i) {
            int length;
            for (length = 0; array2[offset + length] != 13 && offset + length < read; ++length) {}
            array[i] = new String(array2, offset, length);
            offset = offset + length + 2;
        }
        for (int j = 0; j < this.uni_dat2.length; ++j) {
            int n = 0;
            for (int k = 0; k < this.uni_dat2[j].length; ++k) {
                this.uni_dat2[j][k] = 0;
                final int index = array[j].indexOf(44, n);
                if (index > n) {
                    this.uni_dat2[j][k] = Integer.parseInt(array[j].substring(n, index));
                }
                n = index + 1;
            }
        }
        for (int l = 0; l < this.uni_dat2.length; ++l) {
            final int[] array3 = this.uni_dat2[l];
            final int n2 = 6;
            array3[n2] *= 100;
        }
    }
    
    int cos(int n) {
        n = (n + 512) % 512;
        if (n < 128) {
            return this.cos_tbl[n];
        }
        if (n < 256) {
            return -this.cos_tbl[256 - n];
        }
        if (n < 384) {
            return -this.cos_tbl[n - 256];
        }
        return this.cos_tbl[512 - n];
    }
    
    int sin(final int n) {
        return this.cos(n + 128);
    }
    
    int kaku(final int n, final int n2, final int n3, final int n4) {
        return (512 - this.kaku2(n, n2, n3, n4)) % 512;
    }
    
    int kaku2(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        if (n5 == 0) {
            return (n6 >= 0) ? 128 : 384;
        }
        final int abs = Math.abs(n6 * 4096 / n5);
        int n7 = 0;
        int n8 = 127;
        int n10;
        int n9 = n10 = (n7 + n8) / 2;
        if (abs > -1 * this.sin(127) * 4096 / this.cos(127)) {
            n9 = 128;
        }
        else {
            for (int i = 0; i < 64; ++i) {
                if (-1 * this.sin(n9) * 4096 / this.cos(n9) <= abs && abs <= -1 * this.sin(n8) * 4096 / this.cos(n8)) {
                    n7 = n9;
                }
                else {
                    n8 = n9;
                }
                n9 = (n7 + n8) / 2;
                if (n9 == n10) {
                    break;
                }
                n10 = n9;
            }
        }
        if (n5 >= 0) {
            if (n9 == 0) {
                return 0;
            }
            if (n6 >= 0) {
                return (n9 + 512) % 512;
            }
            return (512 - n9 + 512) % 512;
        }
        else {
            if (n6 >= 0) {
                return (256 - n9 + 512) % 512;
            }
            return (256 + n9 + 512) % 512;
        }
    }
    
    public int random(final int n) {
        return Math.abs(this.ran.nextInt()) % n;
    }
    
    void setQuad(final PrimitiveArray primitiveArray, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        primitiveArray.getVertexArray()[n * 12] = (primitiveArray.getVertexArray()[n * 12 + 3] = n2);
        primitiveArray.getVertexArray()[n * 12 + 6] = (primitiveArray.getVertexArray()[n * 12 + 9] = n2 + n5);
        primitiveArray.getVertexArray()[n * 12 + 1] = (primitiveArray.getVertexArray()[n * 12 + 10] = n3);
        primitiveArray.getVertexArray()[n * 12 + 4] = (primitiveArray.getVertexArray()[n * 12 + 7] = n3 + n6);
        final int[] vertexArray = primitiveArray.getVertexArray();
        final int n11 = n * 12 + 2;
        final int[] vertexArray2 = primitiveArray.getVertexArray();
        final int n12 = n * 12 + 5;
        primitiveArray.getVertexArray()[n * 12 + 8] = (primitiveArray.getVertexArray()[n * 12 + 11] = n4);
        vertexArray[n11] = (vertexArray2[n12] = n4);
        primitiveArray.getTextureCoordArray()[n * 8] = (primitiveArray.getTextureCoordArray()[n * 8 + 2] = n7);
        primitiveArray.getTextureCoordArray()[n * 8 + 4] = (primitiveArray.getTextureCoordArray()[n * 8 + 6] = n7 + n9);
        primitiveArray.getTextureCoordArray()[n * 8 + 1] = (primitiveArray.getTextureCoordArray()[n * 8 + 7] = n8);
        primitiveArray.getTextureCoordArray()[n * 8 + 3] = (primitiveArray.getTextureCoordArray()[n * 8 + 5] = n8 + n10);
    }
    
    void setQuad2(final PrimitiveArray primitiveArray, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        primitiveArray.getVertexArray()[n * 12] = (primitiveArray.getVertexArray()[n * 12 + 3] = n2);
        primitiveArray.getVertexArray()[n * 12 + 6] = (primitiveArray.getVertexArray()[n * 12 + 9] = n2 + n5);
        primitiveArray.getVertexArray()[n * 12 + 1] = (primitiveArray.getVertexArray()[n * 12 + 10] = n3);
        primitiveArray.getVertexArray()[n * 12 + 4] = (primitiveArray.getVertexArray()[n * 12 + 7] = n3 + n6);
        final int[] vertexArray = primitiveArray.getVertexArray();
        final int n7 = n * 12 + 2;
        final int[] vertexArray2 = primitiveArray.getVertexArray();
        final int n8 = n * 12 + 5;
        primitiveArray.getVertexArray()[n * 12 + 8] = (primitiveArray.getVertexArray()[n * 12 + 11] = n4);
        vertexArray[n7] = (vertexArray2[n8] = n4);
    }
    
    void setQuadR(final PrimitiveArray primitiveArray, final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < 4; ++i) {
            final int n5 = primitiveArray.getVertexArray()[n * 12 + i * 3 + 0] - n2;
            final int n6 = primitiveArray.getVertexArray()[n * 12 + i * 3 + 1] - n3;
            final int n7 = (n5 * this.cos(n4) - n6 * this.sin(n4)) / 4096;
            final int n8 = (n5 * this.sin(n4) + n6 * this.cos(n4)) / 4096;
            primitiveArray.getVertexArray()[n * 12 + i * 3 + 0] = n2 + n7;
            primitiveArray.getVertexArray()[n * 12 + i * 3 + 1] = n3 + n8;
        }
    }
    
    void save() {
        try {
            MyCanvas.sivar[6] = 1;
            this.writeData(MyCanvas.os = Connector.openOutputStream("scratchpad:///0;pos=0"), MyCanvas.sivar[6], 1);
            this.writeData(MyCanvas.os, MyCanvas.sivar[7], 1);
            this.writeData(MyCanvas.os, MyCanvas.sivar[8], 1);
            this.writeData(MyCanvas.os, MyCanvas.snd_val[2], 1);
            this.writeData(MyCanvas.os, MyCanvas.snd_val[3], 1);
            this.writeData(MyCanvas.os, this.save0[0], 1);
            for (int i = 1; i < 4; ++i) {
                this.writeData(MyCanvas.os, this.save0[i], 4);
            }
            for (int j = 4; j < this.save0.length; ++j) {
                this.writeData(MyCanvas.os, this.save0[j], 1);
            }
            this.writeData(MyCanvas.os, this.save1[0], 4);
            for (int k = 1; k < this.save1.length; ++k) {
                this.writeData(MyCanvas.os, this.save1[k], 1);
            }
            for (int l = 0; l < this.save2.length; ++l) {
                this.writeData(MyCanvas.os, this.save2[l], 1);
            }
            for (int n = 0; n < this.save5.length; ++n) {
                this.writeData(MyCanvas.os, this.save5[n], 1);
            }
            this.writeData(MyCanvas.os, this.taikenban, 1);
            MyCanvas.os.close();
        }
        catch (final Exception ex) {}
        System.gc();
    }
    
    public void g_load(final int n) {
        try {
            if (MyCanvas.img[n] == null) {
                (MyCanvas.mimg[n] = MediaManager.getImage("scratchpad:///0;pos=" + (1011 + (MyCanvas.data_offset.length - 1) * 4 + MyCanvas.data_offset[n]) + ",length=" + (MyCanvas.data_offset[n + 1] - MyCanvas.data_offset[n]))).use();
                MyCanvas.img[n] = MyCanvas.mimg[n].getImage();
                System.gc();
            }
        }
        catch (final ConnectionException ex) {
            System.out.println("\u8aad\u307f\u8fbc\u307f\u30a8\u30e9\u30fc\uff1a" + ex.toString());
        }
    }
    
    public void g_free(final int n) {
        int n2 = 0;
        try {
            if (MyCanvas.img[n] != null) {
                MyCanvas.img[n].dispose();
                MyCanvas.img[n] = null;
                ++n2;
            }
            if (MyCanvas.mimg[n] != null) {
                MyCanvas.mimg[n].unuse();
                MyCanvas.mimg[n].dispose();
                MyCanvas.mimg[n] = null;
                ++n2;
            }
            if (n2 != 0) {
                System.gc();
            }
        }
        catch (final Exception ex) {
            System.out.println("\u89e3\u653e\u30a8\u30e9\u30fc\uff1a" + ex.toString());
        }
    }
    
    int setScene(final int n) {
        return this.setScene(n, 0);
    }
    
    int setScene(final int n, final int n2) {
        final int[] array = new int[8];
        final String[] array2 = new String[4];
        if (n2 == 0) {
            MyCanvas.sivar[1] = MyCanvas.sivar[0];
            MyCanvas.sivar[3] = MyCanvas.sivar[2];
        }
        MyCanvas.wnd_param[6][1] = 0;
        MyCanvas.sivar[0] = n;
        if ((MyCanvas.sivar[2] = n) == 10) {
            this.createWnd(null);
            this.addItem(1, "\u30cd\u30c3\u30c8\u30ef\u30fc\u30af\u306b", null);
            this.addItem(1, "\u63a5\u7d9a\u3067\u304d\u307e\u305b\u3093", null);
            this.setSoftLabel(0, "\u7d42\u4e86");
        }
        else if (n == 11) {
            this.createWnd(null);
            this.addItem(1, "\u30a8\u30e9\u30fc\u304c", null);
            this.addItem(1, "\u767a\u751f\u3057\u307e\u3057\u305f", null);
            this.setSoftLabel(0, "\u7d42\u4e86");
        }
        else if (n == 12) {
            this.createWnd("\u306f\u3044");
            this.addItem(1, "\u30de\u30a4\u30e1\u30cb\u30e5\u30fc\u767b\u9332\u304c", null);
            this.addItem(1, "\u3055\u308c\u3066\u3044\u307e\u305b\u3093", null);
            this.addItem(1, "\u516c\u5f0f\u30b5\u30a4\u30c8\u306b", null);
            this.addItem(1, "\u63a5\u7d9a\u3057\u307e\u3059\u304b\uff1f", null);
            this.addItem(2, "\u306f\u3044", null);
            this.addItem(2, "\u3044\u3044\u3048", null);
            this.setSoftLabel(0, "\u7d42\u4e86");
        }
        else if (n == 100) {
            this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
            this.setSoftLabel(1, MyCanvas.soft_label[1] = "");
            for (int i = 0; i < this.p_flg.length; ++i) {
                this.p_flg[i] = 0;
            }
        }
        else if (n == 150) {
            this.createWnd("\u9589\u3058\u308b");
            this.addItem(2, "\u7d42\u4e86", null);
            this.addItem(2, "\u8a2d\u5b9a", null);
            this.addItem(2, "\u30a2\u30af\u30bb\u30b9", null);
            this.addItem(2, "\u9589\u3058\u308b", null);
            this.play(-1);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
        }
        else if (n == 350) {
            this.createWnd("\u9589\u3058\u308b");
            this.addItem(2, "\u6226\u95d8\u4e2d\u6b62", null);
            this.addItem(2, "\u8a2d\u5b9a", null);
            this.addItem(2, "\u9589\u3058\u308b", null);
            this.play(-1);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
        }
        else if (n == 352) {
            this.createWnd("\u3044\u3044\u3048");
            this.addItem(1, "\u6226\u95d8\u3092\u4e2d\u6b62\u3057\u3066", null);
            if (this.save3[1] != 0 && this.p_flg[0] != 48) {
                this.addItem(1, "\u30e1\u30a4\u30f3\u30e1\u30cb\u30e5\u30fc\u3078", null);
            }
            else {
                this.addItem(1, "\u30bf\u30a4\u30c8\u30eb\u3078", null);
            }
            this.addItem(1, "\u623b\u308a\u307e\u3059\u304b\uff1f", null);
            this.addItem(2, "\u306f\u3044", null);
            this.addItem(2, "\u3044\u3044\u3048", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
        }
        else if (n == 151 || n == 153 || n == 156 || n == 351) {
            if (n == 153) {
                this.play(-1);
            }
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
            this.createWnd(null);
            this.addItem(4, "BGM", MyCanvas.cfg_vol);
            this.addItem(4, "SE", MyCanvas.cfg_vol);
            MyCanvas.item_param[2][0][0] = MyCanvas.snd_val[2] / 5;
            MyCanvas.item_param[2][0][1] = MyCanvas.snd_val[3] / 5;
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
        }
        else if (n == 152 || n == 154 || n == 161) {
            if (n == 154) {
                this.play(-1);
            }
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
            if (n == 161) {
                this.createWnd("\u306f\u3044");
            }
            else {
                this.createWnd("\u3044\u3044\u3048");
            }
            this.addItem(1, "\u5bfe\u6226\ue642\uff8a\uff9e\uff76\u4e00\u53f0\ue6fd", null);
            this.addItem(1, "\u306b\uff71\uff78\uff7e\uff7d\u3057\u307e\u3059\u304b\uff1f", null);
            this.addItem(2, "\u306f\u3044", null);
            this.addItem(2, "\u3044\u3044\u3048", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
        }
        else if (n == 160) {
            this.play(-1);
            this.createWnd(null);
            this.addItem(1, "\u4f53\u9a13\u7248\u306f\u3053\u3053\u307e\u3067", null);
            this.addItem(1, "\u5bfe\u6226\ue642\uff8a\uff9e\uff76\u4e00\u53f0\ue6fd\u3067", null);
            this.addItem(1, "\u88fd\u54c1\u7248\u3092\uff79\uff9e\uff6f\uff84\u3060!!", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "");
            this.setSoftLabel(1, "");
        }
        else if (n == 155) {
            this.createWnd("\u9589\u3058\u308b");
            this.addItem(2, "\u30bf\u30a4\u30c8\u30eb", null);
            this.addItem(2, "\u8a2d\u5b9a", null);
            this.addItem(2, "\u9589\u3058\u308b", null);
            this.play(-1);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
        }
        else if (n == 157) {
            this.createWnd("\u3044\u3044\u3048");
            this.addItem(1, "\u30bf\u30a4\u30c8\u30eb\u306b", null);
            this.addItem(1, "\u623b\u308a\u307e\u3059\u304b\uff1f", null);
            this.addItem(1, "\u3000\u3000\u3000\u3000\u3000\u3000\u3000", null);
            this.addItem(2, "\u306f\u3044", null);
            this.addItem(2, "\u3044\u3044\u3048", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.play(-1);
        }
        else if (n == 158) {
            this.createWnd("\u306f\u3044");
            this.addItem(1, "\u30bb\u30fc\u30d6\u3057\u307e\u3059\u304b\uff1f", null);
            this.addItem(2, "\u306f\u3044", null);
            this.addItem(2, "\u3044\u3044\u3048", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
        }
        else if (n == 159) {
            this.createWnd(null);
            this.addItem(1, "\u30bb\u30fc\u30d6\u304c", null);
            this.addItem(1, "\u5b8c\u4e86\u3057\u307e\u3057\u305f", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "");
            this.setSoftLabel(1, "");
        }
        else if (n == 300) {
            this.setSoftLabel(0, MyCanvas.soft_label[0] = "\uff92\uff86\uff6d\uff70");
            this.setSoftLabel(1, MyCanvas.soft_label[1] = "\u79fb\u52d5");
        }
        else if (n / 100 == 4) {
            this.setSoftLabel(this.kiri[0] = 0, MyCanvas.soft_label[0] = "");
            this.setSoftLabel(1, MyCanvas.soft_label[1] = "");
        }
        else if (n == 500) {
            this.setSoftLabel(0, MyCanvas.soft_label[0] = "");
            this.setSoftLabel(1, MyCanvas.soft_label[1] = "SKIP");
            for (int j = 0; j < this.hinoko.length; ++j) {
                this.hinoko[j][0] = (j * 48 + this.random(48)) % 240 * 100;
                this.hinoko[j][1] = (240 + this.random(100)) * 100;
                this.hinoko[j][2] = 0;
                this.hinoko[j][3] = (1 + this.random(50)) * 10;
                this.hinoko[j][4] = (1 + this.random(6)) * 100;
                this.hinoko[j][5] = 5 + this.random(15);
            }
            this.play(0);
        }
        else if (n == 501) {
            this.setSoftLabel(0, MyCanvas.soft_label[0] = "");
            this.setSoftLabel(1, MyCanvas.soft_label[1] = "");
            for (int k = 0; k < this.hinoko.length; ++k) {
                this.hinoko[k][0] = (k * 48 + this.random(48)) % 240 * 100;
                this.hinoko[k][1] = (240 + this.random(100)) * 100;
                this.hinoko[k][2] = 0;
                this.hinoko[k][3] = (1 + this.random(50)) * 10;
                this.hinoko[k][4] = (1 + this.random(6)) * 100;
                this.hinoko[k][5] = 5 + this.random(15);
            }
            this.play(5);
        }
        else if (n == 250) {
            this.createWnd(null);
            this.addItem(1, "\u901a\u4fe1\u4e2d", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "");
            this.setSoftLabel(1, "");
        }
        else if (n == 251) {
            this.createWnd(null);
            this.addItem(1, "\u767b\u9332\u306b\u5931\u6557\u3057\u307e\u3057\u305f", null);
            MyCanvas.sivar[2] = MyCanvas.sivar[3];
            this.setSoftLabel(0, "\u623b\u308b");
            this.setSoftLabel(1, "");
        }
        final int[] sivar = MyCanvas.sivar;
        final int n3 = 13;
        final int[] sivar2 = MyCanvas.sivar;
        final int n4 = 14;
        final int[] sivar3 = MyCanvas.sivar;
        final int n5 = 15;
        final int n6 = 0;
        sivar3[n5] = n6;
        sivar[n3] = (sivar2[n4] = n6);
        return -1;
    }
    
    public void processEvent(final int n, final int n2) {
        if (n == 0) {
            final int[] sivar = MyCanvas.sivar;
            final int n3 = 14;
            sivar[n3] |= 1 << n2;
        }
        else if (n == 4) {
            PhoneSystem.setAttribute(0, 1);
            if (MyCanvas.snd_val[1] != 0) {
                for (int i = 0; i < MyCanvas.snd_val[0]; ++i) {
                    MyCanvas.snd_data[6][i] = 1;
                }
                MyCanvas.snd_val[4] = 1;
            }
            if (MyCanvas.sivar[0] == 0) {
                this.setScene(11);
            }
        }
    }
    
    int readData(final InputStream inputStream, final int n) throws Exception {
        int n2 = 0;
        int n3 = 0;
        try {
            if (n == 1) {
                n3 = (byte)inputStream.read();
            }
            else if (n == 2) {
                for (int i = 0; i < n; ++i) {
                    n2 = (short)(n2 + (inputStream.read() << (i << 3)));
                }
                n3 = n2;
            }
            else if (n == 4) {
                for (int j = 0; j < n; ++j) {
                    n3 += inputStream.read() << (j << 3);
                }
            }
            return n3;
        }
        catch (final Exception ex) {
            throw ex;
        }
    }
    
    void writeData(final OutputStream outputStream, final int n, final int n2) throws Exception {
        try {
            for (int i = 0; i < n2; ++i) {
                outputStream.write(n >> (i << 3) & 0xFF);
            }
        }
        catch (final Exception ex) {
            throw ex;
        }
    }
    
    void drawString(final Graphics graphics, final String s, int n, int n2) {
        if ((MyCanvas.sivar[12] & 0x1) == 0x0) {
            if ((MyCanvas.sivar[12] & 0x2) != 0x0) {
                n -= MyCanvas.font[MyCanvas.sivar[11]].stringWidth(s);
            }
            else {
                n -= MyCanvas.font[MyCanvas.sivar[11]].stringWidth(s) / 2;
            }
        }
        if ((MyCanvas.sivar[12] & 0x4) != 0x0) {
            n2 += MyCanvas.font[MyCanvas.sivar[11]].getAscent();
        }
        else if ((MyCanvas.sivar[12] & 0x8) != 0x0) {
            n2 -= MyCanvas.font[MyCanvas.sivar[11]].getHeight() - MyCanvas.font[MyCanvas.sivar[11]].getAscent();
        }
        else {
            n2 = n2 + MyCanvas.font[MyCanvas.sivar[11]].getAscent() - MyCanvas.font[MyCanvas.sivar[11]].getHeight() / 2;
        }
        graphics.drawString(s, n, n2);
        if ((MyCanvas.sivar[12] & 0x10) == 0x0) {
            MyCanvas.sivar[12] = 0;
        }
    }
    
    void createWnd(final String wnd_default) {
        for (int i = 0; i < 2; ++i) {
            final int[] array = MyCanvas.wnd_param[1];
            final int n = i;
            final int[] array2 = MyCanvas.wnd_param[2];
            final int n2 = i;
            final int[] array3 = MyCanvas.wnd_param[3];
            final int n3 = i;
            final int[] array4 = MyCanvas.wnd_param[5];
            final int n4 = i;
            final int n5 = 0;
            array3[n3] = (array4[n4] = n5);
            array[n] = (array2[n2] = n5);
            MyCanvas.wnd_param[4][i] = 6;
        }
        MyCanvas.wnd_default = wnd_default;
        MyCanvas.wnd_param[6][0] = 0;
        MyCanvas.wnd_param[6][1] = 1;
        MyCanvas.wnd_param[8][0] = (MyCanvas.wnd_param[8][1] = 0);
        final int[] sivar = MyCanvas.sivar;
        final int n6 = 13;
        final int[] sivar2 = MyCanvas.sivar;
        final int n7 = 14;
        final int[] sivar3 = MyCanvas.sivar;
        final int n8 = 15;
        final int n9 = 0;
        sivar3[n8] = n9;
        sivar[n6] = (sivar2[n7] = n9);
    }
    
    void addItem(final int n, final String s, final String[] array) {
        int n2;
        if ((n & 0x1) != 0x0) {
            n2 = 0;
        }
        else {
            n2 = 1;
            MyCanvas.item_str[MyCanvas.wnd_param[5][n2]] = array;
        }
        int n3;
        if ((n & 0x4) != 0x0) {
            n3 = MyCanvas.font[0].stringWidth(s) + 18 + MyCanvas.font[0].getHeight() * 3;
        }
        else {
            n3 = MyCanvas.font[0].stringWidth(s) + 18;
        }
        MyCanvas.wnd_str[n2][MyCanvas.wnd_param[5][n2]] = s;
        MyCanvas.item_param[0][n2][MyCanvas.wnd_param[5][n2]] = n;
        MyCanvas.item_param[1][n2][MyCanvas.wnd_param[5][n2]] = 6 + MyCanvas.wnd_param[5][n2] * (MyCanvas.font[0].getHeight() + 6);
        MyCanvas.wnd_param[3][n2] = MyCanvas.item_param[1][n2][MyCanvas.wnd_param[5][n2]] + (MyCanvas.font[0].getHeight() + 6);
        if (n3 > MyCanvas.wnd_param[2][n2]) {
            MyCanvas.wnd_param[2][n2] = n3;
        }
        MyCanvas.wnd_param[0][n2] = this.getWidth() / 2 - MyCanvas.wnd_param[2][n2] / 2;
        final int n4 = this.getHeight() - MyCanvas.wnd_param[3][0] - MyCanvas.wnd_param[3][1];
        int n5;
        if (MyCanvas.wnd_param[5][0] == 0 || MyCanvas.wnd_param[5][1] == 0) {
            n5 = n4 / 2;
        }
        else {
            n5 = n4 / 3;
        }
        final int[] array2 = MyCanvas.wnd_param[5];
        final int n6 = n2;
        ++array2[n6];
        if (MyCanvas.wnd_param[5][0] > 0) {
            MyCanvas.wnd_param[1][0] = n5;
        }
        MyCanvas.wnd_param[1][1] = n5 + MyCanvas.wnd_param[1][0] + MyCanvas.wnd_param[3][0];
    }
    
    void keyWnd() {
        if (MyCanvas.wnd_default != null) {
            for (int i = 0; i < MyCanvas.wnd_param[5][1]; ++i) {
                if (MyCanvas.wnd_default.equals(MyCanvas.wnd_str[1][i])) {
                    MyCanvas.wnd_param[6][0] = i;
                    break;
                }
            }
            MyCanvas.wnd_default = null;
        }
        if ((MyCanvas.sivar[15] & 0x10010) != 0x0) {
            final int[] array = MyCanvas.wnd_param[8];
            final int n = 0;
            ++array[n];
        }
        else {
            MyCanvas.wnd_param[8][0] = 0;
        }
        if ((MyCanvas.sivar[15] & 0x40040) != 0x0) {
            final int[] array2 = MyCanvas.wnd_param[8];
            final int n2 = 1;
            ++array2[n2];
        }
        else {
            MyCanvas.wnd_param[8][1] = 0;
        }
        if ((MyCanvas.sivar[13] & 0x20004) != 0x0) {
            if (MyCanvas.wnd_param[5][1] > 1) {
                this.play(10);
            }
            for (int j = 0; j < MyCanvas.wnd_param[5][1]; ++j) {
                final int[] array3 = MyCanvas.wnd_param[6];
                final int n3 = 0;
                if (--array3[n3] < 0) {
                    MyCanvas.wnd_param[6][0] = MyCanvas.wnd_param[5][1] - 1;
                }
                if ((MyCanvas.item_param[0][1][MyCanvas.wnd_param[6][0]] & 0x6) != 0x0) {
                    break;
                }
            }
        }
        else if ((MyCanvas.sivar[13] & 0x80100) != 0x0) {
            if (MyCanvas.wnd_param[5][1] > 1) {
                this.play(10);
            }
            for (int k = 0; k < MyCanvas.wnd_param[5][1]; ++k) {
                if (++MyCanvas.wnd_param[6][0] >= MyCanvas.wnd_param[5][1]) {
                    MyCanvas.wnd_param[6][0] = 0;
                }
                if ((MyCanvas.item_param[0][1][MyCanvas.wnd_param[6][0]] & 0x6) != 0x0) {
                    break;
                }
            }
        }
        else if ((MyCanvas.item_param[0][1][MyCanvas.wnd_param[6][0]] & 0x4) != 0x0) {
            if ((MyCanvas.sivar[13] & 0x10010) != 0x0 || MyCanvas.wnd_param[8][0] > MyCanvas.sivar[4] / 2) {
                if (MyCanvas.item_param[2][0][MyCanvas.wnd_param[6][0]] > 0) {
                    final int[] array4 = MyCanvas.item_param[2][0];
                    final int n4 = MyCanvas.wnd_param[6][0];
                    --array4[n4];
                }
                if ((MyCanvas.sivar[13] & 0x10010) != 0x0) {
                    this.play(10);
                }
            }
            else if ((MyCanvas.sivar[13] & 0x40040) != 0x0 || MyCanvas.wnd_param[8][1] > MyCanvas.sivar[4] / 2) {
                if (MyCanvas.item_param[2][0][MyCanvas.wnd_param[6][0]] < MyCanvas.item_str[MyCanvas.wnd_param[6][0]].length - 1) {
                    final int[] array5 = MyCanvas.item_param[2][0];
                    final int n5 = MyCanvas.wnd_param[6][0];
                    ++array5[n5];
                }
                if ((MyCanvas.sivar[13] & 0x40040) != 0x0) {
                    this.play(10);
                }
            }
        }
        final int[] array6 = MyCanvas.wnd_param[7];
        final int n6 = 0;
        array6[n6] += 2 / MyCanvas.sivar[5];
    }
    
    void drawWnd(final Graphics graphics) {
        if (MyCanvas.wnd_default != null) {
            for (int i = 0; i < MyCanvas.wnd_param[5][1]; ++i) {
                if (MyCanvas.wnd_default.equals(MyCanvas.wnd_str[1][i])) {
                    MyCanvas.wnd_param[6][0] = i;
                    break;
                }
            }
            MyCanvas.wnd_default = null;
        }
        final Font[] font = MyCanvas.font;
        final int[] sivar = MyCanvas.sivar;
        final int n = 11;
        final int n2 = 0;
        sivar[n] = n2;
        graphics.setFont(font[n2]);
        for (int j = 0; j < 2; ++j) {
            if (MyCanvas.wnd_param[5][j] > 0) {
                this.box(graphics, MyCanvas.wnd_param[0][j], MyCanvas.wnd_param[1][j], MyCanvas.wnd_param[2][j], MyCanvas.wnd_param[3][j]);
                for (int k = 0; k < MyCanvas.wnd_param[5][j]; ++k) {
                    if ((MyCanvas.item_param[0][j][k] & 0x6) != 0x0 && k == MyCanvas.wnd_param[6][0]) {
                        graphics.setColor(Graphics.getColorOfRGB(217, 27, 222));
                        graphics.fillRect(MyCanvas.wnd_param[0][j] + 1, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k], MyCanvas.wnd_param[2][j] - 2, MyCanvas.font[0].getHeight());
                        graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
                        graphics.fillRect(MyCanvas.wnd_param[0][j] + 1, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k] - 1, MyCanvas.wnd_param[2][j] - 2, 1);
                        graphics.fillRect(MyCanvas.wnd_param[0][j] + 1, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k] + MyCanvas.font[0].getHeight(), MyCanvas.wnd_param[2][j] - 2, 1);
                    }
                    graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
                    if ((MyCanvas.item_param[0][j][k] & 0x4) != 0x0) {
                        MyCanvas.sivar[12] = 21;
                        this.drawString(graphics, MyCanvas.wnd_str[j][k], MyCanvas.wnd_param[0][j] + 9, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k]);
                        if (k == MyCanvas.wnd_param[6][0] && MyCanvas.item_param[2][0][k] > 0) {
                            this.drawString(graphics, "<", MyCanvas.wnd_param[0][j] + MyCanvas.wnd_param[2][j] - 9 - MyCanvas.font[0].getHeight() * 5 / 2, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k]);
                        }
                        MyCanvas.sivar[12] = 22;
                        this.drawString(graphics, MyCanvas.item_str[k][MyCanvas.item_param[2][0][k]], MyCanvas.wnd_param[0][j] + MyCanvas.wnd_param[2][j] - 9 - MyCanvas.font[0].getHeight() / 2, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k]);
                        if (k == MyCanvas.wnd_param[6][0] && MyCanvas.item_param[2][0][k] < MyCanvas.item_str[k].length - 1) {
                            this.drawString(graphics, ">", MyCanvas.wnd_param[0][j] + MyCanvas.wnd_param[2][j] - 9, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k]);
                        }
                    }
                    else {
                        MyCanvas.sivar[12] = 4;
                        this.drawString(graphics, MyCanvas.wnd_str[j][k], 120, MyCanvas.wnd_param[1][j] + MyCanvas.item_param[1][j][k]);
                    }
                }
            }
        }
        if (MyCanvas.sivar[0] == 157) {
            final Font[] font2 = MyCanvas.font;
            final int[] sivar2 = MyCanvas.sivar;
            final int n3 = 11;
            final int n4 = 1;
            sivar2[n3] = n4;
            graphics.setFont(font2[n4]);
            graphics.setColor(Graphics.getColorOfRGB(255, 255, 255));
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u203b\u30bb\u30fc\u30d6\u305b\u305a\u306b\u623b\u308b\u3068", 120, MyCanvas.wnd_param[1][0] + MyCanvas.item_param[1][0][2]);
            MyCanvas.sivar[12] = 4;
            this.drawString(graphics, "\u73fe\u5728\u306e\u9032\u884c\u72b6\u614b\u306f\u6d88\u3048\u307e\u3059", 120, MyCanvas.wnd_param[1][0] + MyCanvas.item_param[1][0][2] + 14);
            final Font[] font3 = MyCanvas.font;
            final int[] sivar3 = MyCanvas.sivar;
            final int n5 = 11;
            final int n6 = 0;
            sivar3[n5] = n6;
            graphics.setFont(font3[n6]);
        }
    }
    
    void play(final int n) {
        try {
            if (MyCanvas.snd_val[1] != 0) {
                if (n == -1) {
                    for (int i = 0; i < MyCanvas.snd_val[0]; ++i) {
                        if (MyCanvas.snd_data[2][i] != -1) {
                            final int[] array = MyCanvas.snd_data[2];
                            final int n2 = i;
                            final int[] array2 = MyCanvas.snd_data[5];
                            final int n3 = i;
                            final int[] array3 = MyCanvas.snd_data[0];
                            final int n4 = i;
                            final int n5 = -1;
                            array3[n4] = n5;
                            array[n2] = (array2[n3] = n5);
                            MyCanvas.audio[i].stop();
                        }
                        if (MyCanvas.snd_data[3][i] != -1) {
                            MyCanvas.snd_data[10][i] = MyCanvas.snd_data[3][i];
                            MyCanvas.snd_data[11][i] = MyCanvas.snd_data[4][i];
                            MyCanvas.snd_data[12][i] = MyCanvas.snd_data[7][i];
                            MyCanvas.snd_data[13][i] = MyCanvas.snd_data[8][i];
                            MyCanvas.snd_data[14][i] = MyCanvas.audio[i].getCurrentTime();
                        }
                        else {
                            MyCanvas.snd_data[10][i] = -1;
                        }
                    }
                }
                else if (n == -2) {
                    if (MyCanvas.snd_opt[1] == 0) {
                        for (int j = 0; j < MyCanvas.snd_val[0]; ++j) {
                            final int[] array4 = MyCanvas.snd_data[2];
                            final int n6 = j;
                            final int[] array5 = MyCanvas.snd_data[5];
                            final int n7 = j;
                            final int[] array6 = MyCanvas.snd_data[0];
                            final int n8 = j;
                            final int[] array7 = MyCanvas.snd_data[3];
                            final int n9 = j;
                            final int n10 = -1;
                            array6[n8] = (array7[n9] = n10);
                            array4[n6] = (array5[n7] = n10);
                            MyCanvas.snd_data[10][j] = -1;
                            MyCanvas.audio[j].stop();
                        }
                    }
                    else if (MyCanvas.snd_opt[1] == 1) {
                        for (int k = 0; k < MyCanvas.snd_val[0]; ++k) {
                            if (MyCanvas.snd_data[2][k] == MyCanvas.snd_opt[2] || MyCanvas.snd_data[10][k] == MyCanvas.snd_opt[2]) {
                                final int[] array8 = MyCanvas.snd_data[2];
                                final int n11 = k;
                                final int[] array9 = MyCanvas.snd_data[5];
                                final int n12 = k;
                                final int[] array10 = MyCanvas.snd_data[0];
                                final int n13 = k;
                                final int[] array11 = MyCanvas.snd_data[3];
                                final int n14 = k;
                                final int n15 = -1;
                                array10[n13] = (array11[n14] = n15);
                                array8[n11] = (array9[n12] = n15);
                                MyCanvas.snd_data[10][k] = -1;
                                MyCanvas.audio[k].stop();
                                break;
                            }
                        }
                    }
                    else if (MyCanvas.snd_opt[1] == 2) {
                        final int[] array12 = MyCanvas.snd_data[2];
                        final int n16 = MyCanvas.snd_opt[2];
                        final int[] array13 = MyCanvas.snd_data[5];
                        final int n17 = MyCanvas.snd_opt[2];
                        final int[] array14 = MyCanvas.snd_data[0];
                        final int n18 = MyCanvas.snd_opt[2];
                        final int[] array15 = MyCanvas.snd_data[3];
                        final int n19 = MyCanvas.snd_opt[2];
                        final int n20 = -1;
                        array14[n18] = (array15[n19] = n20);
                        array12[n16] = (array13[n17] = n20);
                        MyCanvas.snd_data[10][MyCanvas.snd_opt[2]] = -1;
                        MyCanvas.audio[MyCanvas.snd_opt[2]].stop();
                    }
                }
                else if (n == -3) {
                    for (int l = 0; l < MyCanvas.snd_val[0]; ++l) {
                        if (MyCanvas.snd_data[10][l] != -1 && (MyCanvas.snd_ele[MyCanvas.snd_data[10][l]] & 0x200) != 0x0 && (((MyCanvas.snd_ele[MyCanvas.snd_data[10][l]] & 0x1) != 0x0 && MyCanvas.snd_val[2] > 0) || ((MyCanvas.snd_ele[MyCanvas.snd_data[10][l]] & 0x2) != 0x0 && MyCanvas.snd_val[3] > 0))) {
                            MyCanvas.snd_opt[0] = MyCanvas.snd_data[11][l];
                            MyCanvas.snd_opt[4] = MyCanvas.snd_data[12][l];
                            MyCanvas.snd_opt[5] = MyCanvas.snd_data[13][l];
                            MyCanvas.snd_opt[6] = MyCanvas.snd_data[14][l];
                            MyCanvas.snd_opt[3] = l;
                            this.play(MyCanvas.snd_data[10][l]);
                        }
                    }
                }
                else if (n == -4) {
                    for (int n21 = 0; n21 < MyCanvas.snd_val[0]; ++n21) {
                        if (MyCanvas.snd_data[0][n21] != -1) {
                            if (MyCanvas.snd_val[3] > 0) {
                                if (MyCanvas.snd_data[6][n21] != 0) {
                                    MyCanvas.snd_data[6][n21] = 0;
                                    MyCanvas.audio[n21].setSound(MyCanvas.snd[MyCanvas.snd_data[0][n21]]);
                                    MyCanvas.audio[n21].setAttribute(4, MyCanvas.snd_val[3] * MyCanvas.snd_data[4][n21] / 100);
                                    MyCanvas.audio[n21].setAttribute(5, MyCanvas.snd_data[7][n21]);
                                    MyCanvas.audio[n21].setAttribute(3, MyCanvas.snd_data[8][n21]);
                                    MyCanvas.snd_time[n21] = System.currentTimeMillis();
                                    MyCanvas.audio[n21].play(MyCanvas.snd_data[9][n21]);
                                    MyCanvas.snd_data[2][n21] = (MyCanvas.snd_data[3][n21] = MyCanvas.snd_data[0][n21]);
                                    MyCanvas.snd_data[5][n21] = (MyCanvas.snd_data[0][n21] = -1);
                                }
                                else {
                                    MyCanvas.snd_data[5][n21] = MyCanvas.snd_data[0][n21];
                                    MyCanvas.snd_data[0][n21] = -1;
                                    MyCanvas.audio[n21].stop();
                                }
                            }
                            else {
                                MyCanvas.snd_data[3][n21] = MyCanvas.snd_data[0][n21];
                            }
                        }
                    }
                }
                else if ((MyCanvas.snd_ele[n] & 0x1) != 0x0) {
                    int n22;
                    if (MyCanvas.snd_opt[3] != -1) {
                        n22 = MyCanvas.snd_opt[3];
                    }
                    else {
                        n22 = 0;
                    }
                    while (n22 < MyCanvas.snd_val[0]) {
                        if ((MyCanvas.snd_data[1][n22] & 0x1) != 0x0) {
                            if (MyCanvas.snd_data[2][n22] != -1) {
                                MyCanvas.audio[n22].stop();
                                Thread.sleep(50L);
                            }
                            MyCanvas.snd_data[3][n22] = n;
                            MyCanvas.snd_data[4][n22] = MyCanvas.snd_opt[0];
                            MyCanvas.snd_data[7][n22] = MyCanvas.snd_opt[4];
                            MyCanvas.snd_data[8][n22] = MyCanvas.snd_opt[5];
                            MyCanvas.snd_data[9][n22] = MyCanvas.snd_opt[6];
                            if (MyCanvas.snd_val[2] > 0) {
                                MyCanvas.snd_data[2][n22] = n;
                                MyCanvas.audio[n22].setSound(MyCanvas.snd[n]);
                                MyCanvas.audio[n22].setAttribute(4, MyCanvas.snd_val[2] * MyCanvas.snd_data[4][n22] / 100);
                                MyCanvas.audio[n22].setAttribute(5, MyCanvas.snd_data[7][n22]);
                                MyCanvas.audio[n22].setAttribute(3, MyCanvas.snd_data[8][n22]);
                                MyCanvas.audio[n22].play(MyCanvas.snd_data[9][n22]);
                                break;
                            }
                            MyCanvas.snd_data[2][n22] = -1;
                            break;
                        }
                        else {
                            ++n22;
                        }
                    }
                }
                else {
                    int n23 = -1;
                    int n24 = -1;
                    if ((MyCanvas.snd_ele[n] & 0x100) != 0x0) {
                        for (int n25 = 0; n25 < MyCanvas.snd_val[0]; ++n25) {
                            if (MyCanvas.snd_data[2][n25] == n) {
                                n23 = n25;
                                break;
                            }
                        }
                    }
                    if (MyCanvas.snd_val[3] > 0) {
                        final int[] array16 = new int[3];
                        if (MyCanvas.snd_opt[3] != -1) {
                            array16[1] = this.getPriority(MyCanvas.snd_ele[n]);
                            if (MyCanvas.snd_data[2][MyCanvas.snd_opt[3]] >= 0) {
                                array16[0] = this.getPriority(MyCanvas.snd_ele[MyCanvas.snd_data[2][MyCanvas.snd_opt[3]]]);
                            }
                            if (MyCanvas.snd_data[0][MyCanvas.snd_opt[3]] >= 0) {
                                array16[2] = this.getPriority(MyCanvas.snd_ele[MyCanvas.snd_data[0][MyCanvas.snd_opt[3]]]);
                            }
                            if ((MyCanvas.snd_data[2][MyCanvas.snd_opt[3]] == -1 || array16[1] >= array16[0]) && (MyCanvas.snd_data[0][MyCanvas.snd_opt[3]] == -1 || array16[1] >= array16[2])) {
                                n24 = MyCanvas.snd_opt[3];
                            }
                        }
                        else if (n23 != -1) {
                            if ((MyCanvas.snd_ele[MyCanvas.snd_data[2][n23]] & 0x4) != 0x0) {
                                n24 = n23;
                            }
                        }
                        else {
                            for (int n26 = 0; n26 < MyCanvas.snd_val[0]; ++n26) {
                                if (MyCanvas.snd_data[0][n26] == -1 && (MyCanvas.snd_data[1][n26] & 0x2) != 0x0 && MyCanvas.snd_data[6][n26] != 0) {
                                    n24 = n26;
                                    break;
                                }
                            }
                            if (n24 == -1) {
                                final int[] array17 = new int[MyCanvas.snd_val[0]];
                                for (int n27 = 0; n27 < MyCanvas.snd_val[0]; ++n27) {
                                    array17[n27] = n27;
                                }
                                for (int n28 = 1; n28 < MyCanvas.snd_val[0]; ++n28) {
                                    for (int n29 = n28; n29 > 0 && MyCanvas.snd_time[array17[n29 - 1]] > MyCanvas.snd_time[array17[n29]]; --n29) {
                                        final int n30 = array17[n29];
                                        array17[n29] = array17[n29 - 1];
                                        array17[n29 - 1] = n30;
                                    }
                                }
                                int n31 = 1;
                                for (int n32 = 0; n32 < MyCanvas.snd_val[0]; ++n32) {
                                    if (MyCanvas.snd_data[0][array17[n32]] == -1 && (MyCanvas.snd_data[1][array17[n32]] & 0x2) != 0x0 && MyCanvas.snd_data[2][array17[n32]] != -1 && (MyCanvas.snd_ele[MyCanvas.snd_data[2][array17[n32]]] & 0x4) != 0x0) {
                                        array16[0] = this.getPriority(MyCanvas.snd_ele[MyCanvas.snd_data[2][array17[n32]]]);
                                        array16[1] = this.getPriority(MyCanvas.snd_ele[n]);
                                        if (array16[0] - array16[1] < n31) {
                                            n24 = array17[n32];
                                            n31 = array16[0] - array16[1];
                                        }
                                    }
                                }
                            }
                            if (n24 == -1) {
                                int n33 = 0;
                                for (int n34 = 0; n34 < MyCanvas.snd_val[0]; ++n34) {
                                    if (MyCanvas.snd_data[0][n34] != -1) {
                                        array16[0] = this.getPriority(MyCanvas.snd_ele[n]);
                                        array16[1] = this.getPriority(MyCanvas.snd_ele[MyCanvas.snd_data[0][n34]]);
                                        if (array16[0] - array16[1] > n33) {
                                            n24 = n34;
                                            n33 = array16[0] - array16[1];
                                        }
                                    }
                                }
                            }
                        }
                        if (n24 != -1) {
                            MyCanvas.snd_data[4][n24] = MyCanvas.snd_opt[0];
                            MyCanvas.snd_data[7][n24] = MyCanvas.snd_opt[4];
                            MyCanvas.snd_data[8][n24] = MyCanvas.snd_opt[5];
                            MyCanvas.snd_data[9][n24] = MyCanvas.snd_opt[6];
                            MyCanvas.snd_data[0][n24] = n;
                        }
                    }
                }
            }
            MyCanvas.snd_opt[0] = 100;
            MyCanvas.snd_opt[4] = 100;
            MyCanvas.snd_opt[5] = 0;
            MyCanvas.snd_opt[6] = 0;
            MyCanvas.snd_opt[1] = 0;
            MyCanvas.snd_opt[2] = 0;
            MyCanvas.snd_opt[3] = -1;
        }
        catch (final Exception ex) {}
    }
    
    int getPriority(final int n) {
        if ((n & 0x10) != 0x0) {
            return 0;
        }
        if ((n & 0x20) != 0x0) {
            return 1;
        }
        if ((n & 0x40) != 0x0) {
            return 3;
        }
        if ((n & 0x80) != 0x0) {
            return 4;
        }
        return 2;
    }
    
    static {
        MyCanvas.font = new Font[3];
        MyCanvas.sivar = new int[19];
        MyCanvas.slvar = new long[1];
        MyCanvas.givar = new int[1];
        url = new String[] { "http://www.ponos.co.jp/i/taisenbaka/appli/", "http://www.ponos.co.jp/i/taisenbaka/", "nyanko_dm_demo" };
        url2 = new String[] { "http://www.ponos.co.jp/i/taisenbaka/dm/appli/" };
        cfg_vol = new String[21];
        MyCanvas.soft_label = new String[] { "", "" };
        bunrui = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 2, 2, 0, 0, 2, 2, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 3, 2, 2, 2, 1, 0, 0 };
        MyCanvas.trans = new AffineTrans();
        MyCanvas.pri = new PrimitiveArray[10];
        MyCanvas.wnd_param = new int[9][2];
        MyCanvas.item_param = new int[3][2][6];
        MyCanvas.wnd_str = new String[2][6];
        MyCanvas.item_str = new String[6][];
        snd_ele = new int[] { 521, 521, 521, 521, 521, 513, 521, 513, 513, 513, 134, 134, 134, 134, 134, 38, 38, 38, 38, 38, 22, 22, 6, 38, 38, 142, 134, 70, 70, 134, 521, 521, 521, 521 };
        MyCanvas.snd_val = new int[5];
        MyCanvas.snd_opt = new int[7];
    }
    
    class MyMediaListener implements MediaListener
    {
        public void mediaAction(final MediaPresenter mediaPresenter, final int n, final int n2) {
            try {
                int n3;
                for (n3 = 0; n3 < MyCanvas.snd_val[0] && mediaPresenter != MyCanvas.audio[n3]; ++n3) {}
                switch (n) {
                    case 3: {
                        if (MyCanvas.snd_data[2][n3] != -1 && (MyCanvas.snd_ele[MyCanvas.snd_data[2][n3]] & 0x8) != 0x0) {
                            if ((MyCanvas.snd_data[1][n3] & 0x1) != 0x0) {
                                MyCanvas.audio[n3].setAttribute(4, MyCanvas.snd_val[2] * MyCanvas.snd_data[4][n3] / 100);
                            }
                            else {
                                MyCanvas.audio[n3].setAttribute(4, MyCanvas.snd_val[3] * MyCanvas.snd_data[4][n3] / 100);
                            }
                            MyCanvas.audio[n3].setAttribute(5, MyCanvas.snd_data[7][n3]);
                            MyCanvas.audio[n3].setAttribute(3, MyCanvas.snd_data[8][n3]);
                            MyCanvas.audio[n3].play();
                            break;
                        }
                        MyCanvas.snd_data[2][n3] = (MyCanvas.snd_data[3][n3] = -1);
                        MyCanvas.snd_data[6][n3] = 1;
                        if (MyCanvas.platform.indexOf("SA") == 0) {
                            (MyCanvas.audio[n3] = AudioPresenter.getAudioPresenter(n3)).setMediaListener((MediaListener)MyCanvas.mml[n3]);
                            MyCanvas.audio[n3].setSound(MyCanvas.snd[0]);
                            break;
                        }
                        break;
                    }
                    case 2: {
                        if ((MyCanvas.snd_data[1][n3] & 0x2) == 0x0) {
                            MyCanvas.snd_data[6][n3] = 1;
                            break;
                        }
                        if (MyCanvas.snd_data[5][n3] != -1) {
                            MyCanvas.snd_data[2][n3] = (MyCanvas.snd_data[3][n3] = MyCanvas.snd_data[5][n3]);
                            MyCanvas.snd_data[5][n3] = -1;
                            MyCanvas.audio[n3].setSound(MyCanvas.snd[MyCanvas.snd_data[2][n3]]);
                            MyCanvas.audio[n3].setAttribute(4, MyCanvas.snd_val[3] * MyCanvas.snd_data[4][n3] / 100);
                            MyCanvas.audio[n3].setAttribute(5, MyCanvas.snd_data[7][n3]);
                            MyCanvas.audio[n3].setAttribute(3, MyCanvas.snd_data[8][n3]);
                            MyCanvas.snd_time[n3] = System.currentTimeMillis();
                            MyCanvas.audio[n3].play(MyCanvas.snd_data[9][n3]);
                            break;
                        }
                        MyCanvas.snd_data[2][n3] = (MyCanvas.snd_data[3][n3] = -1);
                        MyCanvas.snd_data[6][n3] = 1;
                        break;
                    }
                }
            }
            catch (final Exception ex) {}
        }
    }
}


