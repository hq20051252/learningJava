package org.apache.hadoop.learn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.RegionSplitter.SplitAlgorithm;

public class FileSplitAlgorithm implements SplitAlgorithm {
    public static final String SPLIT_KEY_FILE = "regions";
    
    @Override
    public byte[][] split(int numberOfSplits) {
        BufferedReader br = null;
        try {
            File keyFile = new File(SPLIT_KEY_FILE);
            if (!keyFile.exists()) {
                throw new FileNotFoundException("Splitting key file not found: " + SPLIT_KEY_FILE);
            }
            List<byte[]> regions = new ArrayList<byte[]> ();
            br = new BufferedReader(new FileReader(keyFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() > 0) {
                    regions.add(Bytes.toBytes(line));
                }
            }
            return regions.toArray(new byte[0][]);
        } catch (IOException e) {
            throw new RuntimeException("Error reading splitting keys from " + SPLIT_KEY_FILE, e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
    
    @Override
    public byte[] firstRow() {
        return null;
    }
    
    @Override
    public byte[] lastRow() {
        return null;
    }

    @Override
    public String rowToStr(byte[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String separator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] split(byte[] arg0, byte[] arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] strToRow(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
