package com.soft.demo.util;

import org.slf4j.LoggerFactory;

/**
 * @Auther: lps
 * DateTime: 2019/3/25 17:36
 * @Version: 1.0
 */
public class Logger {

    private static org.slf4j.Logger logger = null;
    private static org.slf4j.Logger accessLogger = null;

    private Logger() {
    }

    public static synchronized org.slf4j.Logger getLogger() {
        if (null == logger) {
            try {
                logger = LoggerFactory.getLogger("root");
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return logger;
    }

    public static synchronized org.slf4j.Logger getAccessLogger() {
        if (null == accessLogger) {
            try {
                accessLogger = LoggerFactory.getLogger("accesslog");
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return accessLogger;
    }

    public static void access(String msg) {
        try {
            getAccessLogger().info(msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private static String getClazzName() {
        try {
            StackTraceElement a = Thread.currentThread().getStackTrace()[3];
            return a.getClassName();
        } catch (Exception var1) {
            return "";
        }
    }

    public static void trace(String msg) {
        try {
            getLogger().trace("[" + getClazzName() + "]:" + msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void trace(String objName, String msg) {
        try {
            getLogger().trace("[" + objName + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void trace(Object obj, String msg) {
        try {
            getLogger().trace("[" + obj.getClass().getName() + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void debug(String msg) {
        try {
            getLogger().debug("[" + getClazzName() + "]:" + msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void debug(String objName, String msg) {
        try {
            getLogger().debug("[" + objName + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void debug(Object obj, String msg) {
        try {
            getLogger().debug("[" + obj.getClass().getName() + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void info(String msg) {
        try {
            getLogger().info("[" + getClazzName() + "]:" + msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void info(String objName, String msg) {
        try {
            getLogger().info("[" + objName + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void info(Object obj, String msg) {
        try {
            getLogger().info("[" + obj.getClass().getName() + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void warn(String msg) {
        try {
            getLogger().warn("[" + getClazzName() + "]:" + msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void warn(String objName, String msg) {
        try {
            getLogger().warn("[" + objName + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void warn(Object obj, String msg) {
        try {
            getLogger().warn("[" + obj.getClass().getName() + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void error(String msg) {
        try {
            getLogger().error("[" + getClazzName() + "]:" + msg);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void error(String msg, Exception e) {
        try {
            getLogger().error("[" + getClazzName() + "]:" + msg, e);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void error(String objName, String msg) {
        try {
            getLogger().error("[" + objName + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void error(String objName, String msg, Exception e) {
        try {
            getLogger().error("[" + objName + "]:" + msg, e);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void error(Object obj, String msg) {
        try {
            getLogger().error("[" + obj.getClass().getName() + "]:" + msg);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void error(Object obj, String msg, Exception e) {
        try {
            getLogger().error("[" + obj.getClass().getName() + "]:" + msg, e);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

}
