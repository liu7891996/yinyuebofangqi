package text.bwie.com.yinyuebofangqi.modle.url;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class Url {
    //接口详情网址：http://67zixue.com/home/article/detail/id/22.html

    //开始
    public static final String URL="http://tingapi.ting.baidu.com/v1/restserver/ting?";
    /**
     *   格式，json还是xml  json或xmml
     *   calback=&from=webapp_music&method=以下不同的参数获得不同的数据
     *   calback是等于空的
     */
     public static final String RTF_JSON="format=json&calback=&from=webapp_music&method=";
     public static final String RTF_XMML="format=xmml&calback=&from=webapp_music&method=";

    /**
     * method=baidu.ting.billboard.billList&type=1&size=10&offset=0
     *
     * type = 1-新歌榜,2-热歌榜,11-摇滚榜,12-爵士,16-流行,21-欧美金曲榜,
     * 22-经典老歌榜,23-情歌对唱榜,24-影视金曲榜,25-网络歌曲榜
     *
     *  size = 10 //返回条目数
     *  offset = 0 //获取偏移
     *
     */
     public static final String TERM="baidu.ting.billboard.billList";
     public  static final String TYPE="&type=";
     public static final String SIZE="&size=";
     public static final String OFFSET="&offset=";

    /**
     * 、获取歌手信息

     例：method=baidu.ting.artist.getInfo&tinguid=877578

     参数：	tinguid = 877578 //歌手ting id
     *
     */
    public static final String TING_UID="baidu.ting.artist.getInfo&tinguid=";


    /**
     * 四、音乐播放

     * 例：method=baidu.ting.song.play&songid=877578

     * 例：method=baidu.ting.song.playAAC&songid=877578

     * 参数：songid = 877578 //歌曲id
     */

    public static final String SONG_ID="baidu.ting.song.play&songid=";


    /**
     * 三、搜索

     例：method=baidu.ting.search.catalogSug&query=海阔天空

     参数：query = '' //搜索关键字
     */
     public static final  String SEARCH="baidu.ting.search.catalogSug&query=";


    /**
     *五、LRC歌词

     例：method=baidu.ting.song.lry&songid=877578

     参数：songid = 877578 //歌曲id
     */
    public static final String LYRIC="baidu.ting.song.lry&songid=";
}
