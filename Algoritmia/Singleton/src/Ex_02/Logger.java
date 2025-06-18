package Ex_02;

import Ex_01.DatabaseConection;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String fileName;

    private Logger (String fileName){
        this.fileName = fileName;
    }

    private static Logger getInstance(String fileName){
        if (instance == null) {
            instance = new Logger(fileName);
        }
        return instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void logDaMensagem (String mensagem) throws IOException{
        FileWriter fw = new FileWriter(fileName, true);
        fw.append("log xpto..");
        fw.close();
    }
}
