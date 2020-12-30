package xyl.filter;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterImp implements FilenameFilter {
    private String endwith;

    public FileFilterImp(String endwith) {
        this.endwith = endwith;
    }

    @Override
    public boolean accept(File dir, String name) {
        boolean b = name.toUpperCase().endsWith(this.endwith.toUpperCase());
        if(b){
            b = name.contains("YQMX");
        }
        return b;
    }
}
