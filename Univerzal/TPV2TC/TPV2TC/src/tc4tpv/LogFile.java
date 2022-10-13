package tc4tpv;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile {

	public static void makelog(String process, String mess)
	  {
	    Logger logger = Logger.getLogger("MyLog");
	    try
	    {
	      FileHandler fh = new FileHandler("C:/temp/import_ready.log");
	      logger.addHandler(fh);
	      SimpleFormatter formatter = new SimpleFormatter();
	      fh.setFormatter(formatter);
	      
	      logger.info("process:" + process);
	    }
	    catch (SecurityException e)
	    {
	      e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    logger.info(mess);
	  }
}
