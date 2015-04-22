package org.apache.hadoop.learn;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.Parser;
import org.apache.commons.cli.GnuParser;


public class TestCLI {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Options opts = new Options();
		
		Option table = OptionBuilder.withLongOpt("table")
                .hasArg()
				.withArgName("table")
				.withDescription("set Table name")
                .isRequired()
				.create("t");
        opts.addOption(table);
        Parser p = new PosixParser();
        CommandLine cl;
        try{
        	cl = p.parse(opts, args);
        	if (cl.hasOption("table")) {
                String tablename = cl.getOptionValue("table");
        		System.out.println(tablename);
                System.out.println("Yes");
        	}
        } catch(ParseException e) {
        	System.out.println("error");
        }
        return;
	}
}
