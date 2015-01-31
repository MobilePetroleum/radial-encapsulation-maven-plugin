package com.mobilepetroleum.radialencapsulation;

import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Files {

    static List<String> removeMissingFiles(List<String> files, Log log) {
        List<String> existingFiles = new ArrayList<String>();
        for (String file : files) {
            if (new File(file).exists()) {
                existingFiles.add(file);
            } else {
                log.warn("Directory [" + file + "] do not exist");
            }
        }
        return existingFiles;
    }

}
