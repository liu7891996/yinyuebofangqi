package text.bwie.com.yinyuebofangqi.view.bean;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class BofangMusicBean {

    /**
     * songinfo : {"special_type":0,"pic_huge":"http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_1000,h_1000","ting_uid":"90654808","pic_premium":"http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_500,h_500","havehigh":2,"si_proxycompany":"北京中子街声文化发展有限公司","author":"赵雷","toneid":"0","has_mv":0,"song_id":"274841326","title":"成都","artist_id":"13874366","lrclink":"http://musicdata.baidu.com/data2/lrc/b02df89ece73338f2248f32813f35ddd/549929948/549929948.lrc","relate_status":"0","learn":0,"pic_big":"http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_150,h_150","play_type":0,"album_id":"275347355","pic_radio":"http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_300,h_300","bitrate_fee":"{\"0\":\"129|-1\",\"1\":\"-1|-1\"}","song_source":"web","all_artist_id":"13874366","all_artist_ting_uid":"90654808","piao_id":"0","charge":0,"copy_type":"0","all_rate":"64,128,256,320,flac","korean_bb_song":"0","is_first_publish":0,"has_mv_mobile":0,"album_title":"无法长大","pic_small":"http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_90,h_90","album_no":"6","resource_type_ext":"0","resource_type":"0"}
     * error_code : 22000
     * bitrate : {"show_link":"http://zhangmenshiting.baidu.com/data2/music/239908cd71a27d737fef95b17d18b97c/540728460/540728460.mp3?xcode=1190c5f0fbf4aee8b4504f1dc3711450","free":0,"song_file_id":540728460,"file_size":2619789,"file_extension":"mp3","file_duration":327,"file_bitrate":64,"file_link":"http://yinyueshiting.baidu.com/data2/music/239908cd71a27d737fef95b17d18b97c/540728460/540728460.mp3?xcode=1190c5f0fbf4aee8b4504f1dc3711450","hash":"8914235b7268b28cd2bc5af56c4acfd73eb55358"}
     */

    private SonginfoBean songinfo;
    private int error_code;
    private BitrateBean bitrate;

    public SonginfoBean getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(SonginfoBean songinfo) {
        this.songinfo = songinfo;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public BitrateBean getBitrate() {
        return bitrate;
    }

    public void setBitrate(BitrateBean bitrate) {
        this.bitrate = bitrate;
    }

    public static class SonginfoBean {
        /**
         * special_type : 0
         * pic_huge : http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_1000,h_1000
         * ting_uid : 90654808
         * pic_premium : http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_500,h_500
         * havehigh : 2
         * si_proxycompany : 北京中子街声文化发展有限公司
         * author : 赵雷
         * toneid : 0
         * has_mv : 0
         * song_id : 274841326
         * title : 成都
         * artist_id : 13874366
         * lrclink : http://musicdata.baidu.com/data2/lrc/b02df89ece73338f2248f32813f35ddd/549929948/549929948.lrc
         * relate_status : 0
         * learn : 0
         * pic_big : http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_150,h_150
         * play_type : 0
         * album_id : 275347355
         * pic_radio : http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_300,h_300
         * bitrate_fee : {"0":"129|-1","1":"-1|-1"}
         * song_source : web
         * all_artist_id : 13874366
         * all_artist_ting_uid : 90654808
         * piao_id : 0
         * charge : 0
         * copy_type : 0
         * all_rate : 64,128,256,320,flac
         * korean_bb_song : 0
         * is_first_publish : 0
         * has_mv_mobile : 0
         * album_title : 无法长大
         * pic_small : http://musicdata.baidu.com/data2/pic/cd8dcc4f40cbb37c7dcf0e6c151fbcc6/275347355/275347355.jpg@s_1,w_90,h_90
         * album_no : 6
         * resource_type_ext : 0
         * resource_type : 0
         */

        private int special_type;
        private String pic_huge;
        private String ting_uid;
        private String pic_premium;
        private int havehigh;
        private String si_proxycompany;
        private String author;
        private String toneid;
        private int has_mv;
        private String song_id;
        private String title;
        private String artist_id;
        private String lrclink;
        private String relate_status;
        private int learn;
        private String pic_big;
        private int play_type;
        private String album_id;
        private String pic_radio;
        private String bitrate_fee;
        private String song_source;
        private String all_artist_id;
        private String all_artist_ting_uid;
        private String piao_id;
        private int charge;
        private String copy_type;
        private String all_rate;
        private String korean_bb_song;
        private int is_first_publish;
        private int has_mv_mobile;
        private String album_title;
        private String pic_small;
        private String album_no;
        private String resource_type_ext;
        private String resource_type;

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public String getPic_huge() {
            return pic_huge;
        }

        public void setPic_huge(String pic_huge) {
            this.pic_huge = pic_huge;
        }

        public String getTing_uid() {
            return ting_uid;
        }

        public void setTing_uid(String ting_uid) {
            this.ting_uid = ting_uid;
        }

        public String getPic_premium() {
            return pic_premium;
        }

        public void setPic_premium(String pic_premium) {
            this.pic_premium = pic_premium;
        }

        public int getHavehigh() {
            return havehigh;
        }

        public void setHavehigh(int havehigh) {
            this.havehigh = havehigh;
        }

        public String getSi_proxycompany() {
            return si_proxycompany;
        }

        public void setSi_proxycompany(String si_proxycompany) {
            this.si_proxycompany = si_proxycompany;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getToneid() {
            return toneid;
        }

        public void setToneid(String toneid) {
            this.toneid = toneid;
        }

        public int getHas_mv() {
            return has_mv;
        }

        public void setHas_mv(int has_mv) {
            this.has_mv = has_mv;
        }

        public String getSong_id() {
            return song_id;
        }

        public void setSong_id(String song_id) {
            this.song_id = song_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(String artist_id) {
            this.artist_id = artist_id;
        }

        public String getLrclink() {
            return lrclink;
        }

        public void setLrclink(String lrclink) {
            this.lrclink = lrclink;
        }

        public String getRelate_status() {
            return relate_status;
        }

        public void setRelate_status(String relate_status) {
            this.relate_status = relate_status;
        }

        public int getLearn() {
            return learn;
        }

        public void setLearn(int learn) {
            this.learn = learn;
        }

        public String getPic_big() {
            return pic_big;
        }

        public void setPic_big(String pic_big) {
            this.pic_big = pic_big;
        }

        public int getPlay_type() {
            return play_type;
        }

        public void setPlay_type(int play_type) {
            this.play_type = play_type;
        }

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getPic_radio() {
            return pic_radio;
        }

        public void setPic_radio(String pic_radio) {
            this.pic_radio = pic_radio;
        }

        public String getBitrate_fee() {
            return bitrate_fee;
        }

        public void setBitrate_fee(String bitrate_fee) {
            this.bitrate_fee = bitrate_fee;
        }

        public String getSong_source() {
            return song_source;
        }

        public void setSong_source(String song_source) {
            this.song_source = song_source;
        }

        public String getAll_artist_id() {
            return all_artist_id;
        }

        public void setAll_artist_id(String all_artist_id) {
            this.all_artist_id = all_artist_id;
        }

        public String getAll_artist_ting_uid() {
            return all_artist_ting_uid;
        }

        public void setAll_artist_ting_uid(String all_artist_ting_uid) {
            this.all_artist_ting_uid = all_artist_ting_uid;
        }

        public String getPiao_id() {
            return piao_id;
        }

        public void setPiao_id(String piao_id) {
            this.piao_id = piao_id;
        }

        public int getCharge() {
            return charge;
        }

        public void setCharge(int charge) {
            this.charge = charge;
        }

        public String getCopy_type() {
            return copy_type;
        }

        public void setCopy_type(String copy_type) {
            this.copy_type = copy_type;
        }

        public String getAll_rate() {
            return all_rate;
        }

        public void setAll_rate(String all_rate) {
            this.all_rate = all_rate;
        }

        public String getKorean_bb_song() {
            return korean_bb_song;
        }

        public void setKorean_bb_song(String korean_bb_song) {
            this.korean_bb_song = korean_bb_song;
        }

        public int getIs_first_publish() {
            return is_first_publish;
        }

        public void setIs_first_publish(int is_first_publish) {
            this.is_first_publish = is_first_publish;
        }

        public int getHas_mv_mobile() {
            return has_mv_mobile;
        }

        public void setHas_mv_mobile(int has_mv_mobile) {
            this.has_mv_mobile = has_mv_mobile;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public String getPic_small() {
            return pic_small;
        }

        public void setPic_small(String pic_small) {
            this.pic_small = pic_small;
        }

        public String getAlbum_no() {
            return album_no;
        }

        public void setAlbum_no(String album_no) {
            this.album_no = album_no;
        }

        public String getResource_type_ext() {
            return resource_type_ext;
        }

        public void setResource_type_ext(String resource_type_ext) {
            this.resource_type_ext = resource_type_ext;
        }

        public String getResource_type() {
            return resource_type;
        }

        public void setResource_type(String resource_type) {
            this.resource_type = resource_type;
        }
    }

    public static class BitrateBean {
        /**
         * show_link : http://zhangmenshiting.baidu.com/data2/music/239908cd71a27d737fef95b17d18b97c/540728460/540728460.mp3?xcode=1190c5f0fbf4aee8b4504f1dc3711450
         * free : 0
         * song_file_id : 540728460
         * file_size : 2619789
         * file_extension : mp3
         * file_duration : 327
         * file_bitrate : 64
         * file_link : http://yinyueshiting.baidu.com/data2/music/239908cd71a27d737fef95b17d18b97c/540728460/540728460.mp3?xcode=1190c5f0fbf4aee8b4504f1dc3711450
         * hash : 8914235b7268b28cd2bc5af56c4acfd73eb55358
         */

        private String show_link;
        private int free;
        private int song_file_id;
        private int file_size;
        private String file_extension;
        private int file_duration;
        private int file_bitrate;
        private String file_link;
        private String hash;

        public String getShow_link() {
            return show_link;
        }

        public void setShow_link(String show_link) {
            this.show_link = show_link;
        }

        public int getFree() {
            return free;
        }

        public void setFree(int free) {
            this.free = free;
        }

        public int getSong_file_id() {
            return song_file_id;
        }

        public void setSong_file_id(int song_file_id) {
            this.song_file_id = song_file_id;
        }

        public int getFile_size() {
            return file_size;
        }

        public void setFile_size(int file_size) {
            this.file_size = file_size;
        }

        public String getFile_extension() {
            return file_extension;
        }

        public void setFile_extension(String file_extension) {
            this.file_extension = file_extension;
        }

        public int getFile_duration() {
            return file_duration;
        }

        public void setFile_duration(int file_duration) {
            this.file_duration = file_duration;
        }

        public int getFile_bitrate() {
            return file_bitrate;
        }

        public void setFile_bitrate(int file_bitrate) {
            this.file_bitrate = file_bitrate;
        }

        public String getFile_link() {
            return file_link;
        }

        public void setFile_link(String file_link) {
            this.file_link = file_link;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
