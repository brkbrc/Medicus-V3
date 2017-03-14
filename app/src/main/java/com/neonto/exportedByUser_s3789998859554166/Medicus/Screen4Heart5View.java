package com.neonto.exportedByUser_s3789998859554166.Medicus;

import android.content.*;
import android.content.res.TypedArray;
import android.graphics.*;
import android.text.*;
import android.util.*;
import android.view.*;

public class Screen4Heart5View extends View {



    public Screen4Heart5View(Context context) {
        super(context);
        init(null, 0);
    }
    
    public Screen4Heart5View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    
    public Screen4Heart5View(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }
    
    private void init(AttributeSet attrs, int defStyle) {
        // This method is just a stub that you can extend.
        // If you make this class styleable, you can load XML-declared
        // style attributes using getContext().obtainStyledAttributes().
        
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }


    private int m_realLayoutWidthInPx;
    private int m_realLayoutHeightInPx;

    public void applyLayoutAndContentTransform(int w, int h, String contentTransform, float sc) {
        m_realLayoutWidthInPx = w;
        m_realLayoutHeightInPx = h;
    }
    
    // These drawing objects are created when needed in onDraw().
    // Statics are not thread-safe (reentrant), but this is not an issue
    // because onDraw() is only called on the main thread.
    private static Path[] s_paths = null;
    private static Paint[] s_paints = null;
    
    @Override
    protected void onDraw(Canvas canvas) {
        if (s_paths == null) {
            s_paths = new Path[5];
            s_paints = new Paint[5];
            s_paths[0] = new Path();
            s_paints[0] = new Paint();
            s_paths[0].moveTo(712.47f, 85.77f);
              s_paths[0].lineTo(4281.22f, 85.77f);
            s_paths[0].lineTo(4281.22f, 3321.62f);
            s_paths[0].lineTo(712.47f, 3321.62f);
            
            s_paths[0].close();
            s_paints[0] = new Paint(Paint.ANTI_ALIAS_FLAG);
            s_paints[0].setStyle(Paint.Style.FILL);
            s_paints[0].setARGB(255, 0, 0, 0);
            s_paths[1] = new Path();
            s_paints[1] = new Paint();
            s_paths[1].moveTo(4033.01f, 292.17f);
              s_paths[1].lineTo(3994.86f, 255.98f);
            s_paths[1].lineTo(3955.25f, 222.18f);
            s_paths[1].lineTo(3914.28f, 190.79f);
            s_paths[1].lineTo(3872.04f, 161.78f);
            s_paths[1].lineTo(3828.62f, 135.18f);
            
            s_paths[1].lineTo(3784.13f, 110.96f);
            s_paths[1].lineTo(3738.65f, 89.14f);
            s_paths[1].lineTo(3692.29f, 69.7f);
            s_paths[1].lineTo(3645.12f, 52.65f);
            s_paths[1].lineTo(3597.26f, 37.99f);
            
            s_paths[1].lineTo(3548.79f, 25.72f);
            s_paths[1].lineTo(3499.81f, 15.83f);
            s_paths[1].lineTo(3450.41f, 8.32f);
            s_paths[1].lineTo(3400.68f, 3.19f);
            s_paths[1].lineTo(3350.73f, 0.44f);
            
            s_paths[1].lineTo(3300.65f, 0.07f);
            s_paths[1].lineTo(3250.52f, 2.07f);
            s_paths[1].lineTo(3200.45f, 6.45f);
            s_paths[1].lineTo(3150.53f, 13.20f);
            s_paths[1].lineTo(3100.86f, 22.33f);
            
            s_paths[1].lineTo(3051.52f, 33.82f);
            s_paths[1].lineTo(3002.62f, 47.69f);
            s_paths[1].lineTo(2954.25f, 63.92f);
            s_paths[1].lineTo(2906.49f, 82.52f);
            s_paths[1].lineTo(2859.46f, 103.48f);
            
            s_paths[1].lineTo(2813.23f, 126.80f);
            s_paths[1].lineTo(2767.92f, 152.49f);
            s_paths[1].lineTo(2723.6f, 180.54f);
            s_paths[1].lineTo(2680.38f, 210.94f);
            s_paths[1].lineTo(2638.35f, 243.70f);
            
            s_paths[1].lineTo(2558.23f, 316.29f);
            s_paths[1].lineTo(2539.46f, 335.06f);
            s_paths[1].lineTo(2520.70f, 316.29f);
            s_paths[1].lineTo(2481.33f, 278.82f);
            s_paths[1].lineTo(2440.58f, 243.70f);
            
            s_paths[1].lineTo(2398.55f, 210.94f);
            s_paths[1].lineTo(2355.33f, 180.54f);
            s_paths[1].lineTo(2311.01f, 152.49f);
            s_paths[1].lineTo(2265.69f, 126.80f);
            s_paths[1].lineTo(2219.47f, 103.48f);
            
            s_paths[1].lineTo(2172.43f, 82.52f);
            s_paths[1].lineTo(2124.68f, 63.92f);
            s_paths[1].lineTo(2076.31f, 47.69f);
            s_paths[1].lineTo(2027.40f, 33.82f);
            s_paths[1].lineTo(1978.07f, 22.33f);
            
            s_paths[1].lineTo(1928.39f, 13.20f);
            s_paths[1].lineTo(1878.47f, 6.45f);
            s_paths[1].lineTo(1828.41f, 2.07f);
            s_paths[1].lineTo(1778.28f, 0.07f);
            s_paths[1].lineTo(1728.20f, 0.44f);
            
            s_paths[1].lineTo(1678.25f, 3.19f);
            s_paths[1].lineTo(1628.52f, 8.32f);
            s_paths[1].lineTo(1579.12f, 15.83f);
            s_paths[1].lineTo(1530.14f, 25.72f);
            s_paths[1].lineTo(1481.67f, 37.99f);
            
            s_paths[1].lineTo(1433.80f, 52.65f);
            s_paths[1].lineTo(1386.64f, 69.7f);
            s_paths[1].lineTo(1340.27f, 89.14f);
            s_paths[1].lineTo(1294.80f, 110.96f);
            s_paths[1].lineTo(1250.30f, 135.18f);
            
            s_paths[1].lineTo(1206.89f, 161.78f);
            s_paths[1].lineTo(1164.65f, 190.79f);
            s_paths[1].lineTo(1123.68f, 222.18f);
            s_paths[1].lineTo(1045.91f, 292.17f);
            s_paths[1].lineTo(1009.72f, 330.32f);
            
            s_paths[1].lineTo(975.93f, 369.93f);
            s_paths[1].lineTo(944.53f, 410.90f);
            s_paths[1].lineTo(915.53f, 453.14f);
            s_paths[1].lineTo(888.92f, 496.56f);
            s_paths[1].lineTo(864.70f, 541.05f);
            
            s_paths[1].lineTo(842.88f, 586.53f);
            s_paths[1].lineTo(823.44f, 632.90f);
            s_paths[1].lineTo(806.40f, 680.06f);
            s_paths[1].lineTo(791.74f, 727.93f);
            s_paths[1].lineTo(779.46f, 776.40f);
            
            s_paths[1].lineTo(769.57f, 825.38f);
            s_paths[1].lineTo(762.06f, 874.78f);
            s_paths[1].lineTo(756.93f, 924.50f);
            s_paths[1].lineTo(754.18f, 974.45f);
            s_paths[1].lineTo(753.81f, 1024.54f);
            
            s_paths[1].lineTo(755.82f, 1074.66f);
            s_paths[1].lineTo(760.20f, 1124.73f);
            s_paths[1].lineTo(766.95f, 1174.65f);
            s_paths[1].lineTo(776.07f, 1224.32f);
            s_paths[1].lineTo(787.57f, 1273.66f);
            
            s_paths[1].lineTo(801.43f, 1322.56f);
            s_paths[1].lineTo(817.66f, 1370.94f);
            s_paths[1].lineTo(836.26f, 1418.69f);
            s_paths[1].lineTo(857.22f, 1465.73f);
            s_paths[1].lineTo(880.55f, 1511.95f);
            
            s_paths[1].lineTo(906.23f, 1557.27f);
            s_paths[1].lineTo(934.28f, 1601.58f);
            s_paths[1].lineTo(964.69f, 1644.81f);
            s_paths[1].lineTo(997.45f, 1686.84f);
            s_paths[1].lineTo(1070.04f, 1766.96f);
            
            s_paths[1].lineTo(2538.93f, 3235.85f);
            s_paths[1].lineTo(3989.59f, 1785.18f);
            s_paths[1].lineTo(4008.35f, 1766.42f);
            s_paths[1].lineTo(4045.83f, 1727.10f);
            s_paths[1].lineTo(4080.95f, 1686.40f);
            
            s_paths[1].lineTo(4113.72f, 1644.41f);
            s_paths[1].lineTo(4144.13f, 1601.22f);
            s_paths[1].lineTo(4172.19f, 1556.94f);
            s_paths[1].lineTo(4197.89f, 1511.66f);
            s_paths[1].lineTo(4221.24f, 1465.47f);
            
            s_paths[1].lineTo(4242.22f, 1418.46f);
            s_paths[1].lineTo(4260.83f, 1370.74f);
            s_paths[1].lineTo(4277.08f, 1322.39f);
            s_paths[1].lineTo(4290.97f, 1273.51f);
            s_paths[1].lineTo(4302.49f, 1224.19f);
            
            s_paths[1].lineTo(4311.64f, 1174.54f);
            s_paths[1].lineTo(4318.41f, 1124.64f);
            s_paths[1].lineTo(4322.82f, 1074.58f);
            s_paths[1].lineTo(4324.85f, 1024.47f);
            s_paths[1].lineTo(4324.50f, 974.40f);
            
            s_paths[1].lineTo(4321.78f, 924.46f);
            s_paths[1].lineTo(4316.67f, 874.74f);
            s_paths[1].lineTo(4309.19f, 825.35f);
            s_paths[1].lineTo(4299.32f, 776.37f);
            s_paths[1].lineTo(4287.07f, 727.91f);
            
            s_paths[1].lineTo(4272.43f, 680.05f);
            s_paths[1].lineTo(4255.4f, 632.89f);
            s_paths[1].lineTo(4235.98f, 586.52f);
            s_paths[1].lineTo(4214.17f, 541.05f);
            s_paths[1].lineTo(4189.97f, 496.56f);
            
            s_paths[1].lineTo(4163.38f, 453.14f);
            s_paths[1].lineTo(4134.39f, 410.90f);
            s_paths[1].lineTo(4103.0f, 369.93f);
            s_paths[1].lineTo(4033.01f, 292.17f);
            
            s_paths[1].close();
            s_paints[1] = new Paint(Paint.ANTI_ALIAS_FLAG);
            s_paints[1].setStyle(Paint.Style.FILL);
            s_paints[1].setARGB(255, 0, 0, 0);
            s_paths[2] = new Path();
            s_paints[2] = new Paint();
            s_paths[2].moveTo(2832.71f, 1380.97f);
              s_paths[2].lineTo(2827.21f, 1380.67f);
            s_paths[2].lineTo(2821.82f, 1379.81f);
            s_paths[2].lineTo(2816.56f, 1378.40f);
            s_paths[2].lineTo(2811.47f, 1376.49f);
            s_paths[2].lineTo(2806.59f, 1374.10f);
            
            s_paths[2].lineTo(2801.94f, 1371.27f);
            s_paths[2].lineTo(2797.57f, 1368.04f);
            s_paths[2].lineTo(2793.50f, 1364.42f);
            s_paths[2].lineTo(2789.79f, 1360.46f);
            s_paths[2].lineTo(2786.45f, 1356.18f);
            
            s_paths[2].lineTo(2783.53f, 1351.63f);
            s_paths[2].lineTo(2781.07f, 1346.82f);
            s_paths[2].lineTo(2779.08f, 1341.80f);
            s_paths[2].lineTo(2777.63f, 1336.59f);
            s_paths[2].lineTo(2776.42f, 1325.75f);
            
            s_paths[2].lineTo(2776.42f, 1048.59f);
            s_paths[2].lineTo(2776.17f, 1043.13f);
            s_paths[2].lineTo(2775.44f, 1037.83f);
            s_paths[2].lineTo(2774.24f, 1032.70f);
            s_paths[2].lineTo(2772.60f, 1027.78f);
            
            s_paths[2].lineTo(2770.54f, 1023.10f);
            s_paths[2].lineTo(2768.08f, 1018.67f);
            s_paths[2].lineTo(2765.23f, 1014.54f);
            s_paths[2].lineTo(2762.01f, 1010.73f);
            s_paths[2].lineTo(2758.45f, 1007.27f);
            
            s_paths[2].lineTo(2754.56f, 1004.17f);
            s_paths[2].lineTo(2750.36f, 1001.48f);
            s_paths[2].lineTo(2745.88f, 999.22f);
            s_paths[2].lineTo(2741.14f, 997.41f);
            s_paths[2].lineTo(2736.14f, 996.08f);
            
            s_paths[2].lineTo(2725.49f, 994.99f);
            s_paths[2].lineTo(2352.37f, 994.99f);
            s_paths[2].lineTo(2346.91f, 995.26f);
            s_paths[2].lineTo(2341.62f, 996.08f);
            s_paths[2].lineTo(2336.52f, 997.41f);
            
            s_paths[2].lineTo(2331.64f, 999.22f);
            s_paths[2].lineTo(2326.99f, 1001.48f);
            s_paths[2].lineTo(2322.62f, 1004.17f);
            s_paths[2].lineTo(2318.54f, 1007.27f);
            s_paths[2].lineTo(2314.77f, 1010.73f);
            
            s_paths[2].lineTo(2311.36f, 1014.54f);
            s_paths[2].lineTo(2308.31f, 1018.67f);
            s_paths[2].lineTo(2305.67f, 1023.10f);
            s_paths[2].lineTo(2303.44f, 1027.78f);
            s_paths[2].lineTo(2301.67f, 1032.70f);
            
            s_paths[2].lineTo(2300.37f, 1037.83f);
            s_paths[2].lineTo(2299.30f, 1048.59f);
            s_paths[2].lineTo(2299.30f, 1325.75f);
            s_paths[2].lineTo(2299.01f, 1331.23f);
            s_paths[2].lineTo(2298.18f, 1336.59f);
            
            s_paths[2].lineTo(2296.82f, 1341.80f);
            s_paths[2].lineTo(2294.98f, 1346.82f);
            s_paths[2].lineTo(2292.68f, 1351.63f);
            s_paths[2].lineTo(2289.94f, 1356.18f);
            s_paths[2].lineTo(2286.80f, 1360.46f);
            
            s_paths[2].lineTo(2283.28f, 1364.42f);
            s_paths[2].lineTo(2279.42f, 1368.04f);
            s_paths[2].lineTo(2275.24f, 1371.27f);
            s_paths[2].lineTo(2270.77f, 1374.10f);
            s_paths[2].lineTo(2266.05f, 1376.49f);
            
            s_paths[2].lineTo(2261.10f, 1378.40f);
            s_paths[2].lineTo(2255.94f, 1379.81f);
            s_paths[2].lineTo(2245.15f, 1380.97f);
            s_paths[2].lineTo(1967.45f, 1380.97f);
            s_paths[2].lineTo(1961.98f, 1381.23f);
            
            s_paths[2].lineTo(1956.64f, 1382.0f);
            s_paths[2].lineTo(1951.46f, 1383.24f);
            s_paths[2].lineTo(1946.47f, 1384.95f);
            s_paths[2].lineTo(1941.71f, 1387.09f);
            s_paths[2].lineTo(1937.20f, 1389.65f);
            
            s_paths[2].lineTo(1932.97f, 1392.60f);
            s_paths[2].lineTo(1929.06f, 1395.91f);
            s_paths[2].lineTo(1925.49f, 1399.58f);
            s_paths[2].lineTo(1922.3f, 1403.56f);
            s_paths[2].lineTo(1919.52f, 1407.85f);
            
            s_paths[2].lineTo(1917.17f, 1412.41f);
            s_paths[2].lineTo(1915.29f, 1417.22f);
            s_paths[2].lineTo(1913.91f, 1422.27f);
            s_paths[2].lineTo(1912.77f, 1432.97f);
            s_paths[2].lineTo(1912.77f, 1806.09f);
            
            s_paths[2].lineTo(1913.06f, 1811.53f);
            s_paths[2].lineTo(1913.91f, 1816.79f);
            s_paths[2].lineTo(1915.29f, 1821.84f);
            s_paths[2].lineTo(1917.17f, 1826.66f);
            s_paths[2].lineTo(1919.52f, 1831.22f);
            
            s_paths[2].lineTo(1922.3f, 1835.50f);
            s_paths[2].lineTo(1925.49f, 1839.49f);
            s_paths[2].lineTo(1929.06f, 1843.15f);
            s_paths[2].lineTo(1932.97f, 1846.46f);
            s_paths[2].lineTo(1937.20f, 1849.41f);
            
            s_paths[2].lineTo(1941.71f, 1851.97f);
            s_paths[2].lineTo(1946.47f, 1854.11f);
            s_paths[2].lineTo(1951.46f, 1855.82f);
            s_paths[2].lineTo(1956.64f, 1857.07f);
            s_paths[2].lineTo(1967.45f, 1858.09f);
            
            s_paths[2].lineTo(2244.61f, 1858.09f);
            s_paths[2].lineTo(2250.08f, 1858.39f);
            s_paths[2].lineTo(2255.41f, 1859.26f);
            s_paths[2].lineTo(2260.56f, 1860.66f);
            s_paths[2].lineTo(2265.51f, 1862.57f);
            
            s_paths[2].lineTo(2270.24f, 1864.96f);
            s_paths[2].lineTo(2274.70f, 1867.79f);
            s_paths[2].lineTo(2278.88f, 1871.03f);
            s_paths[2].lineTo(2282.74f, 1874.64f);
            s_paths[2].lineTo(2286.26f, 1878.61f);
            
            s_paths[2].lineTo(2289.40f, 1882.88f);
            s_paths[2].lineTo(2292.14f, 1887.44f);
            s_paths[2].lineTo(2294.45f, 1892.24f);
            s_paths[2].lineTo(2296.29f, 1897.26f);
            s_paths[2].lineTo(2297.64f, 1902.47f);
            
            s_paths[2].lineTo(2298.76f, 1913.31f);
            s_paths[2].lineTo(2298.76f, 2190.47f);
            s_paths[2].lineTo(2299.03f, 2195.93f);
            s_paths[2].lineTo(2299.83f, 2201.24f);
            s_paths[2].lineTo(2301.13f, 2206.36f);
            
            s_paths[2].lineTo(2302.91f, 2211.28f);
            s_paths[2].lineTo(2305.13f, 2215.97f);
            s_paths[2].lineTo(2307.78f, 2220.39f);
            s_paths[2].lineTo(2310.82f, 2224.52f);
            s_paths[2].lineTo(2314.24f, 2228.33f);
            
            s_paths[2].lineTo(2318.0f, 2231.80f);
            s_paths[2].lineTo(2322.08f, 2234.89f);
            s_paths[2].lineTo(2326.46f, 2237.58f);
            s_paths[2].lineTo(2331.1f, 2239.85f);
            s_paths[2].lineTo(2335.99f, 2241.66f);
            
            s_paths[2].lineTo(2341.09f, 2242.98f);
            s_paths[2].lineTo(2351.83f, 2244.08f);
            s_paths[2].lineTo(2724.95f, 2244.08f);
            s_paths[2].lineTo(2730.38f, 2243.8f);
            s_paths[2].lineTo(2735.61f, 2242.98f);
            
            s_paths[2].lineTo(2740.6f, 2241.66f);
            s_paths[2].lineTo(2745.35f, 2239.85f);
            s_paths[2].lineTo(2749.83f, 2237.58f);
            s_paths[2].lineTo(2754.02f, 2234.89f);
            s_paths[2].lineTo(2757.91f, 2231.80f);
            
            s_paths[2].lineTo(2761.47f, 2228.33f);
            s_paths[2].lineTo(2764.69f, 2224.52f);
            s_paths[2].lineTo(2767.54f, 2220.39f);
            s_paths[2].lineTo(2770.01f, 2215.97f);
            s_paths[2].lineTo(2772.07f, 2211.28f);
            
            s_paths[2].lineTo(2773.71f, 2206.36f);
            s_paths[2].lineTo(2774.90f, 2201.24f);
            s_paths[2].lineTo(2775.88f, 2190.47f);
            s_paths[2].lineTo(2775.88f, 1913.31f);
            s_paths[2].lineTo(2776.19f, 1907.83f);
            
            s_paths[2].lineTo(2777.09f, 1902.47f);
            s_paths[2].lineTo(2778.55f, 1897.26f);
            s_paths[2].lineTo(2780.53f, 1892.24f);
            s_paths[2].lineTo(2783.0f, 1887.44f);
            s_paths[2].lineTo(2785.92f, 1882.88f);
            
            s_paths[2].lineTo(2789.25f, 1878.61f);
            s_paths[2].lineTo(2792.97f, 1874.64f);
            s_paths[2].lineTo(2797.03f, 1871.03f);
            s_paths[2].lineTo(2801.40f, 1867.79f);
            s_paths[2].lineTo(2806.05f, 1864.96f);
            
            s_paths[2].lineTo(2810.94f, 1862.57f);
            s_paths[2].lineTo(2816.03f, 1860.66f);
            s_paths[2].lineTo(2821.29f, 1859.26f);
            s_paths[2].lineTo(2832.17f, 1858.09f);
            s_paths[2].lineTo(3109.33f, 1858.09f);
            
            s_paths[2].lineTo(3114.78f, 1857.83f);
            s_paths[2].lineTo(3120.05f, 1857.07f);
            s_paths[2].lineTo(3125.13f, 1855.82f);
            s_paths[2].lineTo(3129.98f, 1854.11f);
            s_paths[2].lineTo(3134.58f, 1851.97f);
            
            s_paths[2].lineTo(3138.91f, 1849.41f);
            s_paths[2].lineTo(3142.94f, 1846.46f);
            s_paths[2].lineTo(3146.65f, 1843.15f);
            s_paths[2].lineTo(3150.02f, 1839.49f);
            s_paths[2].lineTo(3153.02f, 1835.50f);
            
            s_paths[2].lineTo(3155.62f, 1831.22f);
            s_paths[2].lineTo(3157.80f, 1826.66f);
            s_paths[2].lineTo(3159.54f, 1821.84f);
            s_paths[2].lineTo(3160.82f, 1816.79f);
            s_paths[2].lineTo(3161.87f, 1806.09f);
            
            s_paths[2].lineTo(3161.87f, 1432.97f);
            s_paths[2].lineTo(3161.6f, 1427.53f);
            s_paths[2].lineTo(3160.82f, 1422.27f);
            s_paths[2].lineTo(3159.54f, 1417.22f);
            s_paths[2].lineTo(3157.80f, 1412.41f);
            
            s_paths[2].lineTo(3155.62f, 1407.85f);
            s_paths[2].lineTo(3153.02f, 1403.56f);
            s_paths[2].lineTo(3150.02f, 1399.58f);
            s_paths[2].lineTo(3146.65f, 1395.91f);
            s_paths[2].lineTo(3142.94f, 1392.60f);
            
            s_paths[2].lineTo(3138.91f, 1389.65f);
            s_paths[2].lineTo(3134.58f, 1387.09f);
            s_paths[2].lineTo(3129.98f, 1384.95f);
            s_paths[2].lineTo(3125.13f, 1383.24f);
            s_paths[2].lineTo(3120.05f, 1382.0f);
            
            s_paths[2].lineTo(3109.33f, 1380.97f);
            s_paths[2].lineTo(2832.71f, 1380.97f);
            
            s_paths[2].close();
            s_paints[2] = new Paint(Paint.ANTI_ALIAS_FLAG);
            s_paints[2].setStyle(Paint.Style.FILL);
            s_paints[2].setARGB(255, 0, 0, 0);
            s_paths[3] = new Path();
            s_paints[3] = new Paint();
            s_paths[3].moveTo(1129.54f, 1828.07f);
              s_paths[3].lineTo(1141.60f, 1839.94f);
            s_paths[3].lineTo(1153.76f, 1851.93f);
            s_paths[3].lineTo(1166.15f, 1864.17f);
            s_paths[3].lineTo(1178.91f, 1876.81f);
            s_paths[3].lineTo(1192.20f, 1889.99f);
            
            s_paths[3].lineTo(1206.16f, 1903.85f);
            s_paths[3].lineTo(1220.92f, 1918.52f);
            s_paths[3].lineTo(1236.63f, 1934.15f);
            s_paths[3].lineTo(1253.43f, 1950.88f);
            s_paths[3].lineTo(1271.47f, 1968.85f);
            
            s_paths[3].lineTo(1290.89f, 1988.20f);
            s_paths[3].lineTo(1311.83f, 2009.08f);
            s_paths[3].lineTo(1334.44f, 2031.61f);
            s_paths[3].lineTo(1358.85f, 2055.95f);
            s_paths[3].lineTo(1413.67f, 2110.59f);
            
            s_paths[3].lineTo(1490.26f, 2097.04f);
            s_paths[3].lineTo(1560.14f, 2081.20f);
            s_paths[3].lineTo(1623.82f, 2062.92f);
            s_paths[3].lineTo(1681.79f, 2042.04f);
            s_paths[3].lineTo(1734.57f, 2018.39f);
            
            s_paths[3].lineTo(1782.65f, 1991.82f);
            s_paths[3].lineTo(1826.54f, 1962.16f);
            s_paths[3].lineTo(1866.74f, 1929.26f);
            s_paths[3].lineTo(1903.75f, 1892.95f);
            s_paths[3].lineTo(1938.08f, 1853.08f);
            
            s_paths[3].lineTo(1970.24f, 1809.48f);
            s_paths[3].lineTo(2000.72f, 1762.0f);
            s_paths[3].lineTo(2030.03f, 1710.47f);
            s_paths[3].lineTo(2058.66f, 1654.73f);
            s_paths[3].lineTo(2115.95f, 1530.0f);
            
            s_paths[3].lineTo(2131.08f, 1497.13f);
            s_paths[3].lineTo(2147.41f, 1465.01f);
            s_paths[3].lineTo(2164.83f, 1433.55f);
            s_paths[3].lineTo(2183.19f, 1402.68f);
            s_paths[3].lineTo(2202.36f, 1372.31f);
            
            s_paths[3].lineTo(2222.22f, 1342.36f);
            s_paths[3].lineTo(2242.62f, 1312.75f);
            s_paths[3].lineTo(2263.44f, 1283.40f);
            s_paths[3].lineTo(2284.55f, 1254.23f);
            s_paths[3].lineTo(2305.80f, 1225.14f);
            
            s_paths[3].lineTo(2327.07f, 1196.07f);
            s_paths[3].lineTo(2348.22f, 1166.94f);
            s_paths[3].lineTo(2369.13f, 1137.65f);
            s_paths[3].lineTo(2389.65f, 1108.13f);
            s_paths[3].lineTo(2429.03f, 1048.06f);
            
            s_paths[3].lineTo(2435.03f, 1038.75f);
            s_paths[3].lineTo(2441.41f, 1029.14f);
            s_paths[3].lineTo(2447.96f, 1019.28f);
            s_paths[3].lineTo(2454.43f, 1009.22f);
            s_paths[3].lineTo(2460.61f, 998.98f);
            
            s_paths[3].lineTo(2466.26f, 988.62f);
            s_paths[3].lineTo(2471.16f, 978.19f);
            s_paths[3].lineTo(2475.07f, 967.71f);
            s_paths[3].lineTo(2477.76f, 957.24f);
            s_paths[3].lineTo(2479.02f, 946.82f);
            
            s_paths[3].lineTo(2478.61f, 936.50f);
            s_paths[3].lineTo(2476.30f, 926.31f);
            s_paths[3].lineTo(2471.86f, 916.30f);
            s_paths[3].lineTo(2465.07f, 906.51f);
            s_paths[3].lineTo(2443.50f, 887.77f);
            
            s_paths[3].lineTo(2432.81f, 881.78f);
            s_paths[3].lineTo(2422.44f, 877.96f);
            s_paths[3].lineTo(2412.37f, 876.12f);
            s_paths[3].lineTo(2402.57f, 876.07f);
            s_paths[3].lineTo(2393.02f, 877.62f);
            
            s_paths[3].lineTo(2383.71f, 880.57f);
            s_paths[3].lineTo(2374.61f, 884.73f);
            s_paths[3].lineTo(2365.70f, 889.91f);
            s_paths[3].lineTo(2356.96f, 895.92f);
            s_paths[3].lineTo(2348.37f, 902.57f);
            
            s_paths[3].lineTo(2339.91f, 909.67f);
            s_paths[3].lineTo(2331.55f, 917.02f);
            s_paths[3].lineTo(2323.28f, 924.43f);
            s_paths[3].lineTo(2315.07f, 931.71f);
            s_paths[3].lineTo(2298.76f, 945.13f);
            
            s_paths[3].lineTo(2280.38f, 960.07f);
            s_paths[3].lineTo(2262.88f, 976.04f);
            s_paths[3].lineTo(2246.03f, 992.87f);
            s_paths[3].lineTo(2229.62f, 1010.39f);
            s_paths[3].lineTo(2213.41f, 1028.43f);
            
            s_paths[3].lineTo(2197.19f, 1046.84f);
            s_paths[3].lineTo(2180.73f, 1065.43f);
            s_paths[3].lineTo(2163.80f, 1084.04f);
            s_paths[3].lineTo(2146.18f, 1102.51f);
            s_paths[3].lineTo(2127.64f, 1120.67f);
            
            s_paths[3].lineTo(2107.96f, 1138.35f);
            s_paths[3].lineTo(2086.92f, 1155.39f);
            s_paths[3].lineTo(2064.29f, 1171.61f);
            s_paths[3].lineTo(2039.84f, 1186.84f);
            s_paths[3].lineTo(1984.61f, 1213.71f);
            
            s_paths[3].lineTo(2014.74f, 1148.71f);
            s_paths[3].lineTo(2047.97f, 1089.62f);
            s_paths[3].lineTo(2084.17f, 1036.17f);
            s_paths[3].lineTo(2123.21f, 988.06f);
            s_paths[3].lineTo(2164.97f, 945.02f);
            
            s_paths[3].lineTo(2209.32f, 906.76f);
            s_paths[3].lineTo(2256.15f, 873.01f);
            s_paths[3].lineTo(2305.33f, 843.47f);
            s_paths[3].lineTo(2356.73f, 817.88f);
            s_paths[3].lineTo(2410.23f, 795.94f);
            
            s_paths[3].lineTo(2465.70f, 777.38f);
            s_paths[3].lineTo(2523.03f, 761.91f);
            s_paths[3].lineTo(2582.08f, 749.25f);
            s_paths[3].lineTo(2642.74f, 739.13f);
            s_paths[3].lineTo(2768.37f, 725.33f);
            
            s_paths[3].lineTo(2793.89f, 723.90f);
            s_paths[3].lineTo(2822.89f, 723.11f);
            s_paths[3].lineTo(2854.65f, 722.75f);
            s_paths[3].lineTo(2888.45f, 722.63f);
            s_paths[3].lineTo(2923.55f, 722.56f);
            
            s_paths[3].lineTo(2959.23f, 722.33f);
            s_paths[3].lineTo(2994.75f, 721.76f);
            s_paths[3].lineTo(3029.38f, 720.64f);
            s_paths[3].lineTo(3062.41f, 718.78f);
            s_paths[3].lineTo(3093.08f, 715.98f);
            
            s_paths[3].lineTo(3120.68f, 712.05f);
            s_paths[3].lineTo(3144.48f, 706.79f);
            s_paths[3].lineTo(3163.75f, 700.0f);
            s_paths[3].lineTo(3177.76f, 691.48f);
            s_paths[3].lineTo(3187.06f, 668.51f);
            
            s_paths[3].lineTo(3075.21f, 636.33f);
            s_paths[3].lineTo(2962.43f, 613.63f);
            s_paths[3].lineTo(2849.33f, 600.12f);
            s_paths[3].lineTo(2736.53f, 595.56f);
            s_paths[3].lineTo(2624.65f, 599.67f);
            
            s_paths[3].lineTo(2514.32f, 612.2f);
            s_paths[3].lineTo(2406.15f, 632.89f);
            s_paths[3].lineTo(2300.77f, 661.47f);
            s_paths[3].lineTo(2198.79f, 697.68f);
            s_paths[3].lineTo(2100.84f, 741.27f);
            
            s_paths[3].lineTo(2007.53f, 791.97f);
            s_paths[3].lineTo(1919.49f, 849.51f);
            s_paths[3].lineTo(1837.34f, 913.64f);
            s_paths[3].lineTo(1761.69f, 984.10f);
            s_paths[3].lineTo(1632.40f, 1142.95f);
            
            s_paths[3].lineTo(1608.41f, 1179.90f);
            s_paths[3].lineTo(1584.39f, 1218.25f);
            s_paths[3].lineTo(1560.16f, 1257.55f);
            s_paths[3].lineTo(1535.55f, 1297.30f);
            s_paths[3].lineTo(1510.38f, 1337.04f);
            
            s_paths[3].lineTo(1484.47f, 1376.28f);
            s_paths[3].lineTo(1457.65f, 1414.56f);
            s_paths[3].lineTo(1429.76f, 1451.4f);
            s_paths[3].lineTo(1400.60f, 1486.32f);
            s_paths[3].lineTo(1370.02f, 1518.85f);
            
            s_paths[3].lineTo(1337.83f, 1548.52f);
            s_paths[3].lineTo(1303.86f, 1574.84f);
            s_paths[3].lineTo(1267.93f, 1597.35f);
            s_paths[3].lineTo(1229.88f, 1615.57f);
            s_paths[3].lineTo(1146.70f, 1637.22f);
            
            s_paths[3].lineTo(921.54f, 1581.47f);
            s_paths[3].lineTo(922.35f, 1582.73f);
            s_paths[3].lineTo(923.18f, 1584.1f);
            s_paths[3].lineTo(924.03f, 1585.57f);
            s_paths[3].lineTo(924.9f, 1587.14f);
            
            s_paths[3].lineTo(925.8f, 1588.80f);
            s_paths[3].lineTo(926.73f, 1590.54f);
            s_paths[3].lineTo(927.70f, 1592.37f);
            s_paths[3].lineTo(928.71f, 1594.27f);
            s_paths[3].lineTo(929.76f, 1596.24f);
            
            s_paths[3].lineTo(930.86f, 1598.27f);
            s_paths[3].lineTo(932.02f, 1600.36f);
            s_paths[3].lineTo(933.23f, 1602.50f);
            s_paths[3].lineTo(934.49f, 1604.69f);
            s_paths[3].lineTo(935.83f, 1606.92f);
            
            s_paths[3].lineTo(938.70f, 1611.49f);
            s_paths[3].lineTo(949.48f, 1627.78f);
            s_paths[3].lineTo(961.39f, 1644.39f);
            s_paths[3].lineTo(974.21f, 1661.17f);
            s_paths[3].lineTo(987.74f, 1677.97f);
            
            s_paths[3].lineTo(1001.77f, 1694.66f);
            s_paths[3].lineTo(1016.09f, 1711.07f);
            s_paths[3].lineTo(1030.50f, 1727.06f);
            s_paths[3].lineTo(1044.77f, 1742.50f);
            s_paths[3].lineTo(1058.72f, 1757.22f);
            
            s_paths[3].lineTo(1072.13f, 1771.09f);
            s_paths[3].lineTo(1084.78f, 1783.95f);
            s_paths[3].lineTo(1096.48f, 1795.66f);
            s_paths[3].lineTo(1107.02f, 1806.08f);
            s_paths[3].lineTo(1116.18f, 1815.05f);
            
            s_paths[3].lineTo(1129.54f, 1828.07f);
            
            s_paths[3].close();
            s_paints[3] = new Paint(Paint.ANTI_ALIAS_FLAG);
            s_paints[3].setStyle(Paint.Style.FILL);
            s_paints[3].setARGB(255, 0, 0, 0);
            s_paths[4] = new Path();
            s_paints[4] = new Paint();
            s_paths[4].moveTo(4219.04f, 1471.03f);
              s_paths[4].lineTo(4238.19f, 1430.17f);
            s_paths[4].lineTo(4255.10f, 1388.82f);
            s_paths[4].lineTo(4269.90f, 1347.27f);
            s_paths[4].lineTo(4282.69f, 1305.83f);
            s_paths[4].lineTo(4293.59f, 1264.80f);
            
            s_paths[4].lineTo(4302.73f, 1224.51f);
            s_paths[4].lineTo(4310.20f, 1185.24f);
            s_paths[4].lineTo(4316.14f, 1147.30f);
            s_paths[4].lineTo(4320.65f, 1111.01f);
            s_paths[4].lineTo(4323.84f, 1076.66f);
            
            s_paths[4].lineTo(4325.84f, 1044.56f);
            s_paths[4].lineTo(4326.77f, 1015.01f);
            s_paths[4].lineTo(4326.72f, 988.33f);
            s_paths[4].lineTo(4325.83f, 964.82f);
            s_paths[4].lineTo(4321.97f, 928.51f);
            
            s_paths[4].lineTo(4321.19f, 928.50f);
            s_paths[4].lineTo(4318.88f, 928.49f);
            s_paths[4].lineTo(4315.04f, 928.50f);
            s_paths[4].lineTo(4309.71f, 928.55f);
            s_paths[4].lineTo(4302.90f, 928.67f);
            
            s_paths[4].lineTo(4294.63f, 928.88f);
            s_paths[4].lineTo(4284.92f, 929.20f);
            s_paths[4].lineTo(4273.79f, 929.65f);
            s_paths[4].lineTo(4261.25f, 930.26f);
            s_paths[4].lineTo(4247.34f, 931.05f);
            
            s_paths[4].lineTo(4232.06f, 932.04f);
            s_paths[4].lineTo(4215.44f, 933.26f);
            s_paths[4].lineTo(4197.50f, 934.73f);
            s_paths[4].lineTo(4178.26f, 936.46f);
            s_paths[4].lineTo(4135.94f, 940.84f);
            
            s_paths[4].lineTo(4126.48f, 941.97f);
            s_paths[4].lineTo(4116.63f, 943.32f);
            s_paths[4].lineTo(4106.42f, 944.84f);
            s_paths[4].lineTo(4095.91f, 946.49f);
            s_paths[4].lineTo(4085.14f, 948.22f);
            
            s_paths[4].lineTo(4074.15f, 949.98f);
            s_paths[4].lineTo(4063.0f, 951.74f);
            s_paths[4].lineTo(4051.71f, 953.44f);
            s_paths[4].lineTo(4040.34f, 955.04f);
            s_paths[4].lineTo(4028.94f, 956.49f);
            
            s_paths[4].lineTo(4017.54f, 957.76f);
            s_paths[4].lineTo(4006.20f, 958.78f);
            s_paths[4].lineTo(3994.96f, 959.53f);
            s_paths[4].lineTo(3983.85f, 959.94f);
            s_paths[4].lineTo(3962.25f, 959.60f);
            
            s_paths[4].lineTo(3879.61f, 958.29f);
            s_paths[4].lineTo(3801.82f, 963.21f);
            s_paths[4].lineTo(3728.69f, 974.12f);
            s_paths[4].lineTo(3660.04f, 990.77f);
            s_paths[4].lineTo(3595.66f, 1012.90f);
            
            s_paths[4].lineTo(3535.36f, 1040.26f);
            s_paths[4].lineTo(3478.94f, 1072.59f);
            s_paths[4].lineTo(3426.23f, 1109.64f);
            s_paths[4].lineTo(3377.01f, 1151.16f);
            s_paths[4].lineTo(3331.09f, 1196.89f);
            
            s_paths[4].lineTo(3288.29f, 1246.58f);
            s_paths[4].lineTo(3248.40f, 1299.98f);
            s_paths[4].lineTo(3211.24f, 1356.83f);
            s_paths[4].lineTo(3176.61f, 1416.88f);
            s_paths[4].lineTo(3114.15f, 1545.55f);
            
            s_paths[4].lineTo(3099.03f, 1578.42f);
            s_paths[4].lineTo(3082.69f, 1610.54f);
            s_paths[4].lineTo(3065.28f, 1642.0f);
            s_paths[4].lineTo(3046.92f, 1672.87f);
            s_paths[4].lineTo(3027.74f, 1703.24f);
            
            s_paths[4].lineTo(3007.89f, 1733.19f);
            s_paths[4].lineTo(2987.48f, 1762.80f);
            s_paths[4].lineTo(2966.66f, 1792.15f);
            s_paths[4].lineTo(2945.56f, 1821.33f);
            s_paths[4].lineTo(2924.31f, 1850.41f);
            
            s_paths[4].lineTo(2903.04f, 1879.48f);
            s_paths[4].lineTo(2881.88f, 1908.62f);
            s_paths[4].lineTo(2860.98f, 1937.91f);
            s_paths[4].lineTo(2840.45f, 1967.43f);
            s_paths[4].lineTo(2801.08f, 2027.50f);
            
            s_paths[4].lineTo(2795.08f, 2036.81f);
            s_paths[4].lineTo(2788.69f, 2046.41f);
            s_paths[4].lineTo(2782.15f, 2056.27f);
            s_paths[4].lineTo(2775.67f, 2066.34f);
            s_paths[4].lineTo(2769.49f, 2076.57f);
            
            s_paths[4].lineTo(2763.84f, 2086.93f);
            s_paths[4].lineTo(2758.95f, 2097.37f);
            s_paths[4].lineTo(2755.04f, 2107.84f);
            s_paths[4].lineTo(2752.34f, 2118.31f);
            s_paths[4].lineTo(2751.08f, 2128.73f);
            
            s_paths[4].lineTo(2751.50f, 2139.06f);
            s_paths[4].lineTo(2753.81f, 2149.25f);
            s_paths[4].lineTo(2758.25f, 2159.26f);
            s_paths[4].lineTo(2765.04f, 2169.05f);
            s_paths[4].lineTo(2786.60f, 2187.79f);
            
            s_paths[4].lineTo(2797.29f, 2193.78f);
            s_paths[4].lineTo(2807.66f, 2197.59f);
            s_paths[4].lineTo(2817.74f, 2199.43f);
            s_paths[4].lineTo(2827.54f, 2199.48f);
            s_paths[4].lineTo(2837.08f, 2197.94f);
            
            s_paths[4].lineTo(2846.39f, 2194.99f);
            s_paths[4].lineTo(2855.49f, 2190.83f);
            s_paths[4].lineTo(2864.40f, 2185.64f);
            s_paths[4].lineTo(2873.14f, 2179.63f);
            s_paths[4].lineTo(2881.73f, 2172.98f);
            
            s_paths[4].lineTo(2890.20f, 2165.89f);
            s_paths[4].lineTo(2898.55f, 2158.54f);
            s_paths[4].lineTo(2906.83f, 2151.13f);
            s_paths[4].lineTo(2915.03f, 2143.84f);
            s_paths[4].lineTo(2931.35f, 2130.43f);
            
            s_paths[4].lineTo(2949.73f, 2115.48f);
            s_paths[4].lineTo(2967.23f, 2099.51f);
            s_paths[4].lineTo(2984.07f, 2082.69f);
            s_paths[4].lineTo(3000.49f, 2065.17f);
            s_paths[4].lineTo(3016.69f, 2047.12f);
            
            s_paths[4].lineTo(3032.91f, 2028.72f);
            s_paths[4].lineTo(3049.38f, 2010.13f);
            s_paths[4].lineTo(3066.31f, 1991.51f);
            s_paths[4].lineTo(3083.93f, 1973.04f);
            s_paths[4].lineTo(3102.47f, 1954.88f);
            
            s_paths[4].lineTo(3122.14f, 1937.20f);
            s_paths[4].lineTo(3143.19f, 1920.17f);
            s_paths[4].lineTo(3165.82f, 1903.95f);
            s_paths[4].lineTo(3190.26f, 1888.71f);
            s_paths[4].lineTo(3245.50f, 1861.84f);
            
            s_paths[4].lineTo(3215.36f, 1926.84f);
            s_paths[4].lineTo(3182.13f, 1985.93f);
            s_paths[4].lineTo(3145.94f, 2039.39f);
            s_paths[4].lineTo(3106.9f, 2087.50f);
            s_paths[4].lineTo(3065.14f, 2130.54f);
            
            s_paths[4].lineTo(3020.78f, 2168.80f);
            s_paths[4].lineTo(2973.96f, 2202.55f);
            s_paths[4].lineTo(2924.78f, 2232.08f);
            s_paths[4].lineTo(2873.38f, 2257.68f);
            s_paths[4].lineTo(2819.88f, 2279.61f);
            
            s_paths[4].lineTo(2764.40f, 2298.18f);
            s_paths[4].lineTo(2707.08f, 2313.64f);
            s_paths[4].lineTo(2648.02f, 2326.30f);
            s_paths[4].lineTo(2587.36f, 2336.43f);
            s_paths[4].lineTo(2461.73f, 2350.22f);
            
            s_paths[4].lineTo(2436.22f, 2351.65f);
            s_paths[4].lineTo(2407.22f, 2352.45f);
            s_paths[4].lineTo(2375.45f, 2352.80f);
            s_paths[4].lineTo(2341.65f, 2352.92f);
            s_paths[4].lineTo(2306.55f, 2352.99f);
            
            s_paths[4].lineTo(2270.88f, 2353.22f);
            s_paths[4].lineTo(2235.36f, 2353.79f);
            s_paths[4].lineTo(2200.72f, 2354.91f);
            s_paths[4].lineTo(2167.70f, 2356.78f);
            s_paths[4].lineTo(2137.02f, 2359.57f);
            
            s_paths[4].lineTo(2109.42f, 2363.51f);
            s_paths[4].lineTo(2085.62f, 2368.77f);
            s_paths[4].lineTo(2066.35f, 2375.56f);
            s_paths[4].lineTo(2052.35f, 2384.07f);
            s_paths[4].lineTo(2043.04f, 2407.05f);
            
            s_paths[4].lineTo(2154.89f, 2439.22f);
            s_paths[4].lineTo(2267.68f, 2461.93f);
            s_paths[4].lineTo(2380.78f, 2475.43f);
            s_paths[4].lineTo(2493.58f, 2480.0f);
            s_paths[4].lineTo(2605.45f, 2475.89f);
            
            s_paths[4].lineTo(2715.79f, 2463.35f);
            s_paths[4].lineTo(2823.95f, 2442.67f);
            s_paths[4].lineTo(2929.34f, 2414.09f);
            s_paths[4].lineTo(3031.31f, 2377.87f);
            s_paths[4].lineTo(3129.27f, 2334.28f);
            
            s_paths[4].lineTo(3222.57f, 2283.59f);
            s_paths[4].lineTo(3310.61f, 2226.04f);
            s_paths[4].lineTo(3392.77f, 2161.91f);
            s_paths[4].lineTo(3468.42f, 2091.45f);
            s_paths[4].lineTo(3597.71f, 1932.61f);
            
            s_paths[4].lineTo(3621.69f, 1895.66f);
            s_paths[4].lineTo(3645.71f, 1857.30f);
            s_paths[4].lineTo(3669.94f, 1818.01f);
            s_paths[4].lineTo(3694.56f, 1778.26f);
            s_paths[4].lineTo(3719.73f, 1738.52f);
            
            s_paths[4].lineTo(3745.64f, 1699.27f);
            s_paths[4].lineTo(3772.45f, 1660.99f);
            s_paths[4].lineTo(3800.35f, 1624.16f);
            s_paths[4].lineTo(3829.50f, 1589.23f);
            s_paths[4].lineTo(3860.09f, 1556.70f);
            
            s_paths[4].lineTo(3892.28f, 1527.04f);
            s_paths[4].lineTo(3926.25f, 1500.71f);
            s_paths[4].lineTo(3962.17f, 1478.20f);
            s_paths[4].lineTo(4000.22f, 1459.99f);
            s_paths[4].lineTo(4083.41f, 1438.33f);
            
            s_paths[4].lineTo(4219.04f, 1471.03f);
            
            s_paths[4].close();
            s_paints[4] = new Paint(Paint.ANTI_ALIAS_FLAG);
            s_paints[4].setStyle(Paint.Style.FILL);
            s_paints[4].setARGB(255, 0, 0, 0);
        }
        
        Path path;
        Paint paint;
        
        super.onDraw(canvas);
        
        canvas.save();
        float displayScale = ((m_realLayoutWidthInPx > 0.0f) ? m_realLayoutWidthInPx : canvas.getWidth()) / 526.781397553f;
        canvas.scale(displayScale, displayScale);
        
        canvas.translate(263.390698777f, 121.634386457f);
        canvas.scale(0.073229613f, 0.073229613f);
        canvas.translate(-2519.5f, -1661.0f);
        
        canvas.save();
        canvas.scale(1.0f, 1.0f);
        path = s_paths[0];
        paint = s_paints[0];
        canvas.drawPath(path, paint);
        path = s_paths[1];
        paint = s_paints[1];
        canvas.drawPath(path, paint);
        path = s_paths[2];
        paint = s_paints[2];
        canvas.drawPath(path, paint);
        path = s_paths[3];
        paint = s_paints[3];
        canvas.drawPath(path, paint);
        path = s_paths[4];
        paint = s_paints[4];
        canvas.drawPath(path, paint);
        
        canvas.restore();
        
        canvas.restore();
    }

}
