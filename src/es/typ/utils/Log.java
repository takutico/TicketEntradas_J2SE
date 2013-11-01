package es.typ.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {

    private SimpleDateFormat tdf = new SimpleDateFormat("HH:mm:ss");
    private static Log instance = null;
    private boolean send2file = true; // x defecto esta a false

    private Log() {
        // Delete olds files (one week ago)
        try {
            File logDir = new File(System.getProperty("user.dir") + File.separator + "logs");
            File[] logFiles = logDir.listFiles();
            if (logFiles != null) {
                Calendar calendarOneWeekAgo = Calendar.getInstance();
                calendarOneWeekAgo.add(Calendar.DAY_OF_MONTH, -21);
                for (int x = 0; x < logFiles.length; x++) {
                    File logFile = logFiles[x];
                    if (logFile.isFile()) {
                        Calendar lastModifiedCalendar = Calendar.getInstance();
                        lastModifiedCalendar.setTimeInMillis(logFile.lastModified());
                        if (lastModifiedCalendar.before(calendarOneWeekAgo)) {
                            logFile.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static String getPathLogFile() {
        SimpleDateFormat ymd = new SimpleDateFormat("yyyyMMdd");
        return System.getProperty("user.dir") + File.separator + "logs" + File.separator +
                ymd.format(Calendar.getInstance().getTime()) + "_ticket.log";
    }

    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void setSendToFile(boolean value) {
        send2file = value;
    }

    public void log(String message, Throwable t) {
        log(message, t, true);
    }

    public synchronized void log(String message, Throwable t, boolean sendIncident) {
        Date date = Calendar.getInstance().getTime();
        message = "[" + tdf.format(date) + "]-[" + Thread.currentThread().getId() + "] " + message;
        if (send2file) {
            PrintWriter out = null;
            try {
                out = abrirPrintWriter();
                out.write(message);
                t.printStackTrace(out);
                if (sendIncident) {
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
        System.out.print(message);
        t.printStackTrace(System.out);
    }

    public synchronized void log(String message, Throwable t, long idThread) {
        Date date = Calendar.getInstance().getTime();
        message = "[" + tdf.format(date) + "]-[" + idThread + "] " + message;
        if (send2file) {
            PrintWriter out = null;
            try {
                out = abrirPrintWriter();
                out.write(message);
                t.printStackTrace(out);
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
        System.out.print(message);
        t.printStackTrace(System.out);
    }

    public synchronized void log(String message) {
        Date date = Calendar.getInstance().getTime();
        message = "[" + tdf.format(date) + "]-[" + Thread.currentThread().getId() + "] " + message;
        if (send2file) {
            BufferedWriter out = null;
            try {
                out = abrirBufferedWriter();
                out.write(message);
                out.newLine();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
        System.out.println(message);
    }

    public synchronized void log(String message, long idThread) {
        Date date = Calendar.getInstance().getTime();
        message = "[" + tdf.format(date) + "]-[" + idThread + "] " + message;
        if (send2file) {
            BufferedWriter out = null;
            try {
                out = abrirBufferedWriter();
                out.write(message);
                out.newLine();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception ex) {
                }
            }
        }
        System.out.println(message);
    }

    private BufferedWriter abrirBufferedWriter() throws IOException {
        try {
            return new BufferedWriter(new FileWriter(getPathLogFile(), true));
        } catch (Exception ex) {
            //Puede ser que el directorio no este creado
            File logDir = new File(System.getProperty("user.dir") + File.separator + "logs");
            logDir.mkdir();
            return new BufferedWriter(new FileWriter(getPathLogFile(), true));
        }
    }

    private PrintWriter abrirPrintWriter() throws IOException {
        try {
            File fichero = new File(getPathLogFile());
            if(fichero.exists()){
                return new PrintWriter(fichero);
            }
            return new PrintWriter(new FileWriter(getPathLogFile(), true));
        } catch (Exception ex) {
            //Puede ser que el directorio no este creado
            File logDir = new File(System.getProperty("user.dir") + File.separator + "logs");
            logDir.mkdir();
            return new PrintWriter(new FileWriter(getPathLogFile(), true));
        }
    }
}
