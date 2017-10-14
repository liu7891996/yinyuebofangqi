package text.bwie.com.yinyuebofangqi.view.app;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述：时间转换格式毫秒转为分秒
 * 姓名 ：刘希鑫
 */

public class TimerFormatter {


    public static String formatterTime(int currentPosition) {
        SimpleDateFormat sdateformat=new SimpleDateFormat("mm:ss");
        String format = sdateformat.format(new Date(currentPosition + 0));

      return format;
    }
}
