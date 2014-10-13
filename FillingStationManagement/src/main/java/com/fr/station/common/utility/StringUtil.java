/*
 * $Id: StringUtil.java 46931 2011-01-13 04:14:42Z guyj $
 * 更新履歴： guga 2009/07/31 新規リリース
 */


package com.fr.station.common.utility;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import com.fr.station.common.consts.NumberConsts;


/**
 * 文字列に対するユーティリティクラス
 * @version 1.0
 * @author guga
 */
public final class StringUtil {

    /**
     * INT_10
     */
    public static final int INT_10 = 10;

    /**
     * INT_2
     */
    public static final int INT_2 = 2;

    /**
     * INT_3
     */
    public static final int INT_3 = 3;

    /**
     * INT_4
     */
    public static final int INT_4 = 4;

    /**
     * INT_16
     */
    public static final int INT_16 = 16;

    /**
     * INT_18
     */
    public static final int INT_18 = 18;

    /**
     * 半角イコール
     */
    public static final String EQUAL = "=";

    /**
     * 半角コンマ
     */
    public static final String COMMA = ",";

    /**
     * 半角コンマchar
     */
    public static final char COMMA_CHAR = ',';

    /**
     * 半角スペース
     */
    public static final String SPACE = " ";

    /**
     * 全角スペース
     */
    public static final String ZENKAKU_SPACE = "　";

    /**
     * 全角スペース文字
     */
    public static final char CHAR_ZENKAKU_SPACE = '　';

    /**
     * 半角スペース文字
     */
    public static final char CHAR_SPACE = ' ';

    /**
     * TAB文字
     */
    public static final char CHAR_TAB = '\t';

    /**
     * セミコロン
     */
    public static final String SEMICOLON = ";";

    /**
     * 空文字
     */
    public static final String BLANK = "";

    /**
     * SPLIT
     */
    public static final String SPLIT = "|";

    /**
     * file.separator
     */
    public static final String SEPERTOR = System.getProperty("file.separator");

    /**
     * JOIN
     */
    public static final String JOIN = "_";

    /**
     * AT
     */
    public static final String AT = "@";

    /**
     * DOT
     */
    public static final String DOT = ".";

    /**
     * COLON
     */
    public static final String COLON = ":";

    /**
     * 斜線
     */
    public static final String OBLIQUELINE = "/";

    /**
     * ハイフン
     */
    public static final String HAIFUN = "-";

    /**
     * 百分率CHAR
     */
    public static final char PERCENTAGE_CHAR = '%';

    /**
     * 百分率
     */
    public static final String PERCENTAGE = "%";

    /**
     * ゼロ
     */
    public static final String ZERO = "0";

    /**
     * ゼロ
     */
    public static final BigDecimal BIG_ZERO = new BigDecimal("0");

    /**
     * *
     */
    public static final String COMMEND = "*";

    /**
     * 帳票CSV用改行文字
     */
    public static final String PDF_CSV_LINE_SPEAR = "？";

    /**
     * 条件文言用改行文字
     */
    public static final String JOKEN_LINE_SPEAR = "？";

    /**
     * 計上データ条件文言用改行文字
     */
    public static final String KEIJYOU_LINE_SPEAR = "?";

    /**
     * 改行 LF
     */
    public static final String LINE_SPEAR_LF = "\n";

    /**
     * 改行 CRLF
     */
    public static final String LINE_SPEAR_CRLF = "\r\n";

    /**
     * 改行 line.separator
     */
    public static final String LINE_SPEAR = System.getProperty("line.separator");

    /**
     * 計算結果:0.00
     */
    private static final String DOT_ZERO = ".00";

    /**
     * 換算率:「0.01」
     */
    private static final String POINT_01 = "0.01";

    /**
     * 半角文字から全角文字に変換用のマップ
     */
    private static final Map<String, String> HANTOZEN_MAP;

    /**
     * 半角文字から全角文字に変換用のマップの初期化
     */
    static {
        HANTOZEN_MAP = new HashMap<String, String>();
        // 数字
        HANTOZEN_MAP.put("0", "０");
        HANTOZEN_MAP.put("1", "１");
        HANTOZEN_MAP.put("2", "２");
        HANTOZEN_MAP.put("3", "３");
        HANTOZEN_MAP.put("4", "４");
        HANTOZEN_MAP.put("5", "５");
        HANTOZEN_MAP.put("6", "６");
        HANTOZEN_MAP.put("7", "７");
        HANTOZEN_MAP.put("8", "８");
        HANTOZEN_MAP.put("9", "９");
        // 小英
        HANTOZEN_MAP.put("a", "ａ");
        HANTOZEN_MAP.put("b", "ｂ");
        HANTOZEN_MAP.put("c", "ｃ");
        HANTOZEN_MAP.put("d", "ｄ");
        HANTOZEN_MAP.put("e", "ｅ");
        HANTOZEN_MAP.put("f", "ｆ");
        HANTOZEN_MAP.put("g", "ｇ");
        HANTOZEN_MAP.put("h", "ｈ");
        HANTOZEN_MAP.put("i", "ｉ");
        HANTOZEN_MAP.put("j", "ｊ");
        HANTOZEN_MAP.put("k", "ｋ");
        HANTOZEN_MAP.put("l", "ｌ");
        HANTOZEN_MAP.put("m", "ｍ");
        HANTOZEN_MAP.put("n", "ｎ");
        HANTOZEN_MAP.put("o", "ｏ");
        HANTOZEN_MAP.put("p", "ｐ");
        HANTOZEN_MAP.put("q", "ｑ");
        HANTOZEN_MAP.put("r", "ｒ");
        HANTOZEN_MAP.put("s", "ｓ");
        HANTOZEN_MAP.put("t", "ｔ");
        HANTOZEN_MAP.put("u", "ｕ");
        HANTOZEN_MAP.put("v", "ｖ");
        HANTOZEN_MAP.put("w", "ｗ");
        HANTOZEN_MAP.put("x", "ｘ");
        HANTOZEN_MAP.put("y", "ｙ");
        HANTOZEN_MAP.put("z", "ｚ");
        // 大英
        HANTOZEN_MAP.put("A", "Ａ");
        HANTOZEN_MAP.put("B", "Ｂ");
        HANTOZEN_MAP.put("C", "Ｃ");
        HANTOZEN_MAP.put("D", "Ｄ");
        HANTOZEN_MAP.put("E", "Ｅ");
        HANTOZEN_MAP.put("F", "Ｆ");
        HANTOZEN_MAP.put("G", "Ｇ");
        HANTOZEN_MAP.put("H", "Ｈ");
        HANTOZEN_MAP.put("I", "Ｉ");
        HANTOZEN_MAP.put("J", "Ｊ");
        HANTOZEN_MAP.put("K", "Ｋ");
        HANTOZEN_MAP.put("L", "Ｌ");
        HANTOZEN_MAP.put("M", "Ｍ");
        HANTOZEN_MAP.put("N", "Ｎ");
        HANTOZEN_MAP.put("O", "Ｏ");
        HANTOZEN_MAP.put("P", "Ｐ");
        HANTOZEN_MAP.put("Q", "Ｑ");
        HANTOZEN_MAP.put("R", "Ｒ");
        HANTOZEN_MAP.put("S", "Ｓ");
        HANTOZEN_MAP.put("T", "Ｔ");
        HANTOZEN_MAP.put("U", "Ｕ");
        HANTOZEN_MAP.put("V", "Ｖ");
        HANTOZEN_MAP.put("W", "Ｗ");
        HANTOZEN_MAP.put("X", "Ｘ");
        HANTOZEN_MAP.put("Y", "Ｙ");
        HANTOZEN_MAP.put("Z", "Ｚ");
        // 記号
        HANTOZEN_MAP.put(" ", "　");
        HANTOZEN_MAP.put("!", "！");
        HANTOZEN_MAP.put("#", "＃");
        HANTOZEN_MAP.put("$", "＄");
        HANTOZEN_MAP.put("%", "％");
        HANTOZEN_MAP.put("&", "＆");
        HANTOZEN_MAP.put("'", "’");
        HANTOZEN_MAP.put(String.valueOf('"'), String.valueOf('”'));
        HANTOZEN_MAP.put("(", "（");
        HANTOZEN_MAP.put(")", "）");
        HANTOZEN_MAP.put("*", "＊");
        HANTOZEN_MAP.put("+", "＋");
        HANTOZEN_MAP.put(",", "，");
        HANTOZEN_MAP.put("-", "－");
        HANTOZEN_MAP.put(".", "．");
        HANTOZEN_MAP.put("/", "／");
        HANTOZEN_MAP.put(":", "：");
        HANTOZEN_MAP.put(";", "；");
        HANTOZEN_MAP.put("<", "＜");
        HANTOZEN_MAP.put("=", "＝");
        HANTOZEN_MAP.put(">", "＞");
        HANTOZEN_MAP.put("?", "？");
        HANTOZEN_MAP.put("@", "＠");
        HANTOZEN_MAP.put("[", "［");
        HANTOZEN_MAP.put("]", "］");
        HANTOZEN_MAP.put("^", "＾");
        HANTOZEN_MAP.put("_", "＿");
        HANTOZEN_MAP.put("`", "‘");
        HANTOZEN_MAP.put("{", "｛");
        HANTOZEN_MAP.put("|", "｜");
        HANTOZEN_MAP.put("}", "｝");
        HANTOZEN_MAP.put("~", "～");
        HANTOZEN_MAP.put("｡", "。");
        HANTOZEN_MAP.put("｢", "「");
        HANTOZEN_MAP.put("｣", "」");
        HANTOZEN_MAP.put("､", "、");
        HANTOZEN_MAP.put("･", "・");
        // カナ
        HANTOZEN_MAP.put("ｦ", "ヲ");
        HANTOZEN_MAP.put("ｧ", "ァ");
        HANTOZEN_MAP.put("ｨ", "ィ");
        HANTOZEN_MAP.put("ｩ", "ゥ");
        HANTOZEN_MAP.put("ｪ", "ェ");
        HANTOZEN_MAP.put("ｫ", "ォ");
        HANTOZEN_MAP.put("ｬ", "ャ");
        HANTOZEN_MAP.put("ｭ", "ュ");
        HANTOZEN_MAP.put("ｮ", "ョ");
        HANTOZEN_MAP.put("ｯ", "ッ");
        HANTOZEN_MAP.put("ｰ", "ー");
        HANTOZEN_MAP.put("ｱ", "ア");
        HANTOZEN_MAP.put("ｲ", "イ");
        HANTOZEN_MAP.put("ｳ", "ウ");
        HANTOZEN_MAP.put("ｴ", "エ");
        HANTOZEN_MAP.put("ｵ", "オ");
        HANTOZEN_MAP.put("ｶ", "カ");
        HANTOZEN_MAP.put("ｷ", "キ");
        HANTOZEN_MAP.put("ｸ", "ク");
        HANTOZEN_MAP.put("ｹ", "ケ");
        HANTOZEN_MAP.put("ｺ", "コ");
        HANTOZEN_MAP.put("ｻ", "サ");
        HANTOZEN_MAP.put("ｼ", "シ");
        HANTOZEN_MAP.put("ｽ", "ス");
        HANTOZEN_MAP.put("ｾ", "セ");
        HANTOZEN_MAP.put("ｿ", "ソ");
        HANTOZEN_MAP.put("ﾀ", "タ");
        HANTOZEN_MAP.put("ﾁ", "チ");
        HANTOZEN_MAP.put("ﾂ", "ツ");
        HANTOZEN_MAP.put("ﾃ", "テ");
        HANTOZEN_MAP.put("ﾄ", "ト");
        HANTOZEN_MAP.put("ﾅ", "ナ");
        HANTOZEN_MAP.put("ﾆ", "ニ");
        HANTOZEN_MAP.put("ﾇ", "ヌ");
        HANTOZEN_MAP.put("ﾈ", "ネ");
        HANTOZEN_MAP.put("ﾉ", "ノ");
        HANTOZEN_MAP.put("ﾊ", "ハ");
        HANTOZEN_MAP.put("ﾋ", "ヒ");
        HANTOZEN_MAP.put("ﾌ", "フ");
        HANTOZEN_MAP.put("ﾍ", "ヘ");
        HANTOZEN_MAP.put("ﾎ", "ホ");
        HANTOZEN_MAP.put("ﾏ", "マ");
        HANTOZEN_MAP.put("ﾐ", "ミ");
        HANTOZEN_MAP.put("ﾑ", "ム");
        HANTOZEN_MAP.put("ﾒ", "メ");
        HANTOZEN_MAP.put("ﾓ", "モ");
        HANTOZEN_MAP.put("ﾔ", "ヤ");
        HANTOZEN_MAP.put("ﾕ", "ユ");
        HANTOZEN_MAP.put("ﾖ", "ヨ");
        HANTOZEN_MAP.put("ﾗ", "ラ");
        HANTOZEN_MAP.put("ﾘ", "リ");
        HANTOZEN_MAP.put("ﾙ", "ル");
        HANTOZEN_MAP.put("ﾚ", "レ");
        HANTOZEN_MAP.put("ﾛ", "ロ");
        HANTOZEN_MAP.put("ﾜ", "ワ");
        HANTOZEN_MAP.put("ﾝ", "ン");
        HANTOZEN_MAP.put("ﾞ", "゛");
        HANTOZEN_MAP.put("ﾟ", "゜");
        HANTOZEN_MAP.put("\\", "￥");
    }


    /**
     * コンストラクタ
     */
    private StringUtil() {

    }


    /**
     * 対象文字列の桁数は指定長さより未満の場合、先頭に指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param len 長さ
     * @param str 文字
     * @return 結果文字列
     */
    public static String padLeft(String resultStr, int len, char str) {

        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }

        StringBuffer buf = new StringBuffer(strObj);

        while (buf.length() < len) {
            buf.insert(0, str);
        }
        return buf.toString();
    }


    /**
     * 対象文字列の桁数は指定長さより未満の場合、後ろに指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param len 長さ
     * @param str 文字
     * @return 結果文字列
     */
    public static String padRight(String resultStr, int len, char str) {

        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }

        StringBuffer buf = new StringBuffer(strObj);

        while (buf.length() < len) {
            buf.append(str);
        }
        return buf.toString();
    }


    /**
     * 空文字列かどうかチェック
     * @param text 対象文字列
     * @return boolean チェック結果
     */
    public static boolean isEmpty(String text) {
        if (null == text || text.trim().length() == 0) {
            return true;
        }
        return false;
    }


    /**
     * 空文字列かどうかチェック
     * @param text 対象文字列
     * @return boolean チェック結果
     */
    public static boolean isNotEmpty(String text) {
        if (null != text && text.trim().length() != 0) {
            return true;
        }
        return false;
    }


    /**
     * 空文字列かどうかチェック
     * @param text 対象文字列
     * @return boolean チェック結果
     */
    public static boolean isNotEmptyNotTrim(String text) {
        if (null != text && text.length() != 0) {
            return true;
        }
        return false;
    }


    /**
     * 先頭から、指定バイト数の文字列を取得する
     * @param str 元文字列
     * @param len 指定バイト数
     * @return String 取得した文字列
     */
    public static String getSubString(String str, int len) {
        if (isEmpty(str)) {
            return BLANK;
        }

        if (0 >= len) {
            return str;
        }

        // バイト長さを取得する
        final int byteLength = getByteLength(str);

        if (byteLength < len) {
            return str;
        }

        StringBuffer sb = new StringBuffer(str);

        while (getByteLength(sb.toString()) > len) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }


    /**
     * 先頭から、指定バイト数の文字列を取得する(改行コード処理がある)
     * @param str 元文字列
     * @param len 指定バイト数
     * @return String 取得した文字列
     */
    public static String getSubStrNoSeparator(String str, int len) {
        if (isEmpty(str)) {
            return BLANK;
        }

        if (0 >= len) {
            return str;
        }

        String spword = LINE_SPEAR_CRLF;
        int lineIndex = str.indexOf(spword);
        if (-1 == lineIndex) {
            // LINUXの改行コードを関連処理
            spword = LINE_SPEAR_LF;
            lineIndex = str.indexOf(spword);
        }
        if (-1 != lineIndex) {
            str = str.substring(0, lineIndex);
        }

        // バイト長さを取得する
        final int byteLength = getByteLength(str);

        if (byteLength < len) {
            return str;
        }

        StringBuffer sb = new StringBuffer(str);

        while (getByteLength(sb.toString()) > len) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }


    /**
     * 入力した文字列のバイト長さを取得する
     * @param str 入力した文字列
     * @return バイト長さ
     */
    public static int getByteLength(String str) {
        int len = 0;

        len = str.getBytes().length;

        return len;
    }


    /**
     * 指定した文字エンコーディングを利用して、入力した文字列のバイト長さを取得する
     * @param str 入力した文字列
     * @param encoding 文字エンコーディング
     * @return バイト長さ
     */
    public static int getByteLength(String str, String encoding) {
        int len = 0;

        if (isEmpty(encoding)) {
            len = getByteLength(str);
        } else {
            try {
                len = str.getBytes(encoding).length;
            } catch (UnsupportedEncodingException e) {
                len = getByteLength(str);
            }
        }

        return len;
    }


    /**
     * 文字列はNULLまたは空文字の場合、空文字をリターン
     * @param str 文字列
     * @return String 文字列または空文字
     */
    public static String nvl(String str) {
        if (isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }


    /**
     * 文字は空白かどうかをチェックする
     * @param c 文字
     * @return true 文字列は空白である<br>
     *         false 文字列は空白ではない
     */
    public static boolean isSpace(char c) {
        return c == CHAR_SPACE || c == CHAR_TAB || c == CHAR_ZENKAKU_SPACE;
    }


    /**
     * 文字列の前後空白を除く
     * @param s 文字列
     * @return String 変更された文字列
     */
    public static String trim(String s) {

        if (s == null) {
            return null;
        }

        int begin = 0;
        int end = 0;
        int length = s.length();
        for (begin = 0; begin < length; begin++) {
            if (!isSpace(s.charAt(begin))) {
                break;
            }
        }

        for (end = length - 1; end >= 0; end--) {
            if (!isSpace(s.charAt(end))) {
                break;
            }
        }

        if (end < begin) {
            return "";

        }
        return s.substring(begin, end + 1);
    }


    /**
     * 文字列の前空白を除く
     * @param s 文字列
     * @return String 変更された文字列
     */
    public static String ltrim(String s) {

        if (s == null) {
            return null;
        }

        int begin = 0;
        int length = s.length();

        for (begin = 0; begin < length; begin++) {
            if (!isSpace(s.charAt(begin))) {
                break;
            }
        }
        return s.substring(begin);
    }


    /**
     * 文字列の後空白を除く。
     * @param s 文字列
     * @return String 変更された文字列。
     */
    public static String rtrim(String s) {

        if (s == null) {
            return null;
        }

        int begin = 0;
        int end = 0;
        int length = s.length();

        for (end = length - 1; end >= 0; end--) {
            if (!isSpace(s.charAt(end))) {
                break;
            }
        }

        if (end < begin) {
            return "";
        }
        return s.substring(begin, end + 1);
    }


    /**
     * 小文字から大文字に変換する
     * @param s 文字列
     * @return 大文字
     */
    public static String toUpperCase(String s) {
        if (s == null) {
            return null;
        } else {
            return s.toUpperCase();
        }
    }


    /**
     * 文字列は空白かどうかをチェックする。
     * @param s 文字列
     * @return true 文字列は空白である<br>
     *         false 文字列は空白ではない
     */
    public static boolean isSpace(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!isSpace(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    /**
     * 指定符号で区切って文字列を取得する
     * @param str 文字列(分割前)
     * @param interval 分割区分
     * @return List 文字列リスト(分割後)
     */
    public static List<String> split(String str, String interval) {
        if (null == str) {
            return null;
        }
        StringBuffer sb = new StringBuffer(str);
        List<String> strList = new ArrayList<String>();

        while (sb.length() > 0) {
            int len = sb.indexOf(interval);
            if (len >= 0) {
                strList.add(sb.substring(0, len));
                sb.delete(0, len + 1);
                sb = new StringBuffer(StringUtil.trim(sb.toString()));
            } else {
                strList.add(sb.substring(0, sb.length()));
                sb.delete(0, sb.length());
            }
        }

        return strList;
    }


    /**
     * 整数部と小数部を取得する
     * @param big ナンバ
     * @return String[] 整数部と小数部の配列
     */
    public static String[] splitBigdecimal(BigDecimal big) {
        if (null == big || 0 == BigDecimal.ZERO.compareTo(big)) {
            return new String[] { "", "" };
        } else {
            List<String> list = split(big.toPlainString(), ".");
            int size = list.size();
            if (1 == size) {
                return new String[] { String.valueOf(big), "0" };
            } else {
                return new String[] { list.get(0), list.get(1) };
            }
        }
    }


    /**
     * 整数部 + 小数部を連結する。
     * @param seisu 整数部
     * @param shosu 小数部
     * @return 整数部 + 小数部
     */
    public static BigDecimal connectBigdecimal(String seisu, String shosu) {
        if (isEmpty(seisu) && isEmpty(shosu)) {
            return null;
        } else {
            if (isEmpty(seisu)) {
                seisu = "0";
            }

            if (isEmpty(shosu)) {
                shosu = "0";
            }
            return new BigDecimal(seisu + "." + shosu);
        }
    }


    /**
     * バイトレングスを利用し、対象文字列の桁数はバイトレングスより未満の場合、先頭に指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param byteLength バイトレングス
     * @param str 文字
     * @return 結果文字列
     */
    public static String padLeftByByte(String resultStr, int byteLength, char str) {
        return padLeftByByte(resultStr, byteLength, str, null);
    }


    /**
     * 指定した文字エンコーディングとバイトレングスを利用し、 対象文字列の桁数はバイトレングスより未満の場合、先頭に指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param byteLength バイトレングス
     * @param str 文字
     * @param encoding 文字エンコーディング
     * @return 結果文字列
     */
    public static String padLeftByByte(String resultStr, int byteLength, char str,
        String encoding) {

        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }
        int len = getByteLength(strObj, encoding);
        if (len >= byteLength) {
            return strObj;
        }

        StringBuilder buf = new StringBuilder(byteLength);

        int strByteLen = getByteLength(String.valueOf(str), encoding);
        for (int leftLen = byteLength - len; leftLen > 0; leftLen -= strByteLen) {
            buf.append(str);
        }
        buf.append(strObj);

        return buf.toString();
    }


    /**
     * バイトレングスを利用し、対象文字列の桁数はバイトレングスより未満の場合、後ろに指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param byteLength バイトレングス
     * @param str 文字
     * @return 結果文字列
     */
    public static String padRightByByte(String resultStr, int byteLength, char str) {
        return padRightByByte(resultStr, byteLength, str, null);
    }


    /**
     * 指定した文字エンコーディングとバイトレングスを利用し、 対象文字列の桁数はバイトレングスより未満の場合、後ろに指定文字を埋め込み
     * @param resultStr 対象文字列
     * @param byteLength バイトレングス
     * @param str 文字
     * @param encoding 文字エンコーディング
     * @return 結果文字列
     */
    public static String padRightByByte(String resultStr, int byteLength, char str,
        String encoding) {

        String strObj = resultStr;
        if (null == strObj) {
            strObj = "";
        }
        int len = getByteLength(strObj, encoding);
        if (len >= byteLength) {
            return strObj;
        }

        StringBuilder buf = new StringBuilder(byteLength);

        buf.append(strObj);
        int strByteLen = getByteLength(String.valueOf(str), encoding);
        for (int leftLen = byteLength - len; leftLen > 0; leftLen -= strByteLen) {
            buf.append(str);
        }

        return buf.toString();
    }


    /**
     * バイトレングスを利用し、文字を切る。
     * @param orgStr 元文字
     * @param byteLength バイトレングス
     * @return String
     */
    public static String substringByByte(String orgStr, int byteLength) {
        return substringByByte(orgStr, byteLength, null);
    }


    /**
     * 指定した文字エンコーディングとバイトレングスを利用し、文字を切る。
     * @param orgStr 元文字
     * @param byteLength バイトレングス
     * @param encoding 文字エンコーディング
     * @return String
     */
    public static String substringByByte(String orgStr, int byteLength, String encoding) {
        String str = null;
        if (null == orgStr) {
            return BLANK;
        }
        if (orgStr.length() > byteLength) {
            str = orgStr.substring(0, byteLength);
        } else {
            str = orgStr;
        }

        int byteLen = getByteLength(str, encoding);
        int endIdx = 0;
        if (byteLen <= byteLength) {
            endIdx = str.length();
        } else {
            int subLen = 0;
            int len = str.length();
            endIdx = len / 2;
            int lastIdx = len;
            int moveLen = 0;
            while (true) {
                subLen = getByteLength(str.substring(0, endIdx), encoding);
                if (subLen == byteLength) {
                    break;
                } else if (subLen > byteLength) {
                    moveLen = Math.abs(endIdx - lastIdx) / 2;
                    lastIdx = endIdx;
                    if (moveLen == 0) {
                        endIdx -= 1;
                    } else {
                        endIdx -= moveLen;
                    }
                } else if (lastIdx - endIdx == 1) {
                    break;
                } else {
                    moveLen = Math.abs(endIdx - lastIdx) / 2;
                    lastIdx = endIdx;
                    if (moveLen == 0) {
                        endIdx += 1;
                    } else {
                        endIdx += moveLen;
                    }
                }
            }
        }

        return str.substring(0, endIdx);
    }


    /**
     * BigDecimalからStringに変換する。
     * @param dec BigDecimal
     * @return 変換したString
     */
    public static String convertBigDecimalToString(BigDecimal dec) {
        if (null == dec) {
            return null;
        } else {
            return dec.toPlainString();
        }
    }


    /**
     * 指定の文字によって、文字列から置換する。
     * @param text 文字列
     * @param searchString 文字
     * @param replacement 置換文字
     * @return String 置換後文字列
     */
    public static String replace(String text, String searchString, String replacement) {
        if (null == text) {
            return text;
        }
        String replaced = text;
        for (String prev = null; !replaced.equals(prev);) {
            prev = replaced;
            replaced = StringUtils.replace(replaced, searchString, replacement);
        }
        return replaced;
    }


    /**
     * 行文字列を結合する
     * @param lines 行文字列
     * @param conjunction 接続詞
     * @return 結合する文字列
     */
    public static String joinLines(List<String> lines, String conjunction) {
        if (null == lines || lines.isEmpty()) {
            return null;
        }
        StringBuilder joinLine = new StringBuilder();

        boolean isNotFirst = false;
        for (String str : lines) {
            if (isNotFirst) {
                joinLine.append(conjunction);
            }
            joinLine.append(str);
            isNotFirst = true;
        }

        return joinLine.toString();
    }


    /**
     * 証券番号を結合する
     * @param shokenLines 証券番号文字列
     * @return String 結合した証券番号文字列
     */
    public static String joinShokenNo(List<String> shokenLines) {
        if (null == shokenLines || shokenLines.isEmpty()) {
            return null;
        }
        StringBuilder joinLine = new StringBuilder();

        boolean isNotFirst = false;
        for (String str : shokenLines) {
            if (isEmpty(str)) {
                continue;
            }

            if (isNotFirst) {
                joinLine.append(HAIFUN);
            } else {
                isNotFirst = true;
            }
            joinLine.append(nvl(str));
        }

        return joinLine.toString();
    }


    /**
     * 0をブランクに変換する（金額、料率など数値項目表示用）
     * @param str 変換元
     * @return String 変換結果
     */
    public static String convertZeroToBlank(String str) {
        if (ZERO.equals(str)) {
            return BLANK;
        }

        return str;
    }


    /**
     * 0をブランクに変換する（金額、料率など数値項目表示用）
     * @param num 変換元
     * @return String 変換結果
     */
    public static String convertZeroToBlank(BigDecimal num) {
        if (null != num) {
            if (0 == BigDecimal.ZERO.compareTo(num)) {
                return null;
            } else {
                return num.toPlainString();
            }
        } else {
            return null;
        }
    }


    /**
     * 0をブランクに変換する（金額、料率など数値項目表示用）
     * @param seisu 整数部
     * @param shosu 小数部
     * @return String 変換結果
     */
    public static String convertZeroToBlank(String seisu, String shosu) {
        if (isEmpty(seisu)) {
            seisu = "0";
        }

        if (isEmpty(shosu)) {
            shosu = "0";
        }

        BigDecimal num = new BigDecimal(seisu + "." + shosu);

        if (0 == BigDecimal.ZERO.compareTo(num)) {
            return null;
        } else {
            return String.valueOf(num);
        }
    }


    /**
     * ブランクを0に変換する（金額、料率など数値項目登録用）
     * @param str 変換元
     * @return String 変換結果
     */
    public static BigDecimal convertBlankToZero(String str) {
        if (isEmpty(str)) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(str);
        }
    }


    /**
     * ブランクを0に変換する（金額、料率など数値項目登録用）
     * @param str 変換元
     * @return String 変換結果
     */
    public static BigDecimal convertBlankToZero(BigDecimal str) {
        if (null == str) {
            return BigDecimal.ZERO;
        } else {
            return str;
        }
    }


    /**
     * ブランクを0に変換する（金額、料率など数値項目登録用）
     * @param seisu 整数部
     * @param shosu 小数部
     * @return BigDecimal 変換結果
     */
    public static BigDecimal convertBlankToZero(String seisu, String shosu) {
        if (isEmpty(seisu) && isEmpty(shosu)) {
            return BigDecimal.ZERO;
        } else {
            if (isEmpty(seisu)) {
                seisu = "0";
            }

            if (isEmpty(shosu)) {
                shosu = "0";
            }
            return new BigDecimal(seisu + "." + shosu);
        }
    }


    /**
     * リスト判空
     * @param listVal 判断リスト
     * @return 判断結果
     */
    public static boolean isEmpty(List<?> listVal) {
        boolean flag = false;
        if (null == listVal || listVal.isEmpty()) {
            flag = true;
        }
        return flag;
    }


    /**
     * リスト判非空
     * @param listVal 判断リスト
     * @return 判断結果
     */
    public static boolean isNotEmpty(List<?> listVal) {
        boolean flag = false;
        if (null != listVal && !(listVal.isEmpty())) {
            flag = true;
        }
        return flag;
    }


    /**
     * 半角文字から全角文字に変換
     * @param hankaku 半角文字
     * @return String 全角文字
     */
    public static String hanToZen(String hankaku) {
        return HANTOZEN_MAP.get(hankaku);
    }


    /**
     * Html用の特別なＣｈａｒを切り替える
     * @param sIn 入力したストリング
     * @return 切り替えたストリング
     */
    public static String toHTMLOutStr(String sIn) {

        if (sIn == null || "".equals(sIn.trim())) {
            return "&nbsp;";
        }
        char[] content = new char[sIn.length()];
        sIn.getChars(0, sIn.length(), content, 0);
        StringBuilder result = new StringBuilder(content.length * 2);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                case '\n':
                    result.append("<br>");
                    break;
                case '\r':
                    break;
                case ' ':
                    result.append("&nbsp;");
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return result.toString();
    }


    /**
     * 加法計算
     * @param num1 数字１
     * @param num2 数字２
     * @return 数字１+ 数字２
     */
    public static BigDecimal addKeisan(BigDecimal num1, BigDecimal num2) {
        if (null == num1) {
            num1 = new BigDecimal("0");
        }
        if (null == num2) {
            num2 = new BigDecimal("0");
        }
        return (num1.add(num2));
    }


    /**
     * かけ算計算
     * @param num1 数字１
     * @param num2 数字２
     * @return 数字１* 数字２
     */
    public static BigDecimal kakeiKeisan(BigDecimal num1, BigDecimal num2) {
        if (null == num1) {
            num1 = new BigDecimal("0");
        }
        if (null == num2) {
            num2 = new BigDecimal("0");
        }
        return (num1.multiply(num2));
    }


    /**
     * 数字num == null or 数字num == 数字0の判断
     * @param num 数字num
     * @return true:num == null or num == 数字0; false :その他
     */
    public static boolean isEmpty(BigDecimal num) {
        return (null == num || 0 == BIG_ZERO.compareTo(num));
    }


    /**
     * BigDecimal精度変換 精度が2、値が0.001場合　戻る値は0.01
     * @param val BigDecimal
     * @param scale 精度
     * @param isHoukenData 保険料のフラグ true: はい；false：いいえ
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimalWithScale(BigDecimal val, int scale,
        boolean isHoukenData) {
        if (StringUtil.isEmpty(val)) {
            return new BigDecimal(NumberConsts.NUM_0);
        }

        // 最低保険料場合
        if (isHoukenData) {
            return val.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }

        long longValue = val.longValue();

        BigDecimal value = BigDecimal.ZERO;

        BigDecimal longBigdecimal = BigDecimal.valueOf(longValue);

        // 整数でわない場合
        if ((longBigdecimal.compareTo(val) != 0)) {
            value = val.setScale(scale, BigDecimal.ROUND_HALF_UP);
            if (value.toPlainString().contains(DOT_ZERO)) {
                value = value.add(new BigDecimal(POINT_01));
            }
        } else {
            value = val.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }
        return value;
    }


    /**
     * 証券番号は４部分に割り
     * @param shokenNo 証券番号
     * @return 証券番号Array
     */
    public static String[] getShokenNoList(String shokenNo) {
        shokenNo = padRight(shokenNo, INT_18, ' ');
        String[] shokenNoArray = new String[INT_4];
        // 証券番号-発行店
        shokenNoArray[0] = shokenNo.substring(0, 2);
        // 証券番号-連番
        shokenNoArray[1] = shokenNo.substring(INT_2, INT_10);
        // 証券番号-一括枝番
        shokenNoArray[2] = shokenNo.substring(INT_10, INT_16);
        // 証券番号-履歴枝番
        shokenNoArray[INT_3] = shokenNo.substring(INT_16, INT_18);
        return shokenNoArray;
    }


    /**
     * Html用の特別なＣｈａｒを切り替える(入力データに改行コードがある場合)
     * @param sIn 入力したストリング
     * @return 切り替えたストリング
     */
    public static String filter(String sIn) {

        if (sIn == null || "".equals(sIn.trim())) {
            return "";
        }
        char[] content = new char[sIn.length()];
        sIn.getChars(0, sIn.length(), content, 0);
        StringBuilder result = new StringBuilder(content.length * 2);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                case '\n':
                    result.append("<br>");
                    break;
                case '\r':
                    break;
                default:
                    result.append(content[i]);
            }
        }
        return result.toString();
    }


    /**
     * 文字列に、”’”を”\’”に変更する
     * @param str 文字列
     * @return 変更後文字列
     */
    public static String repalce(String str) {
        if (isEmpty(str)) {
            return BLANK;
        } else {
            char[] content = new char[str.length()];
            str.getChars(0, str.length(), content, 0);
            StringBuilder result = new StringBuilder(content.length * 2);
            for (int i = 0; i < content.length; i++) {
                if ('\'' == content[i] || '\\' == content[i]) {
                    result.append("\\");
                    result.append(content[i]);
                } else {
                    result.append(content[i]);
                }
            }
            return result.toString();
        }
    }


    /**
     * 文字列を連結する
     * @param str1 文字列1
     * @param str2 文字列2
     * @param str3 文字列3
     * @return str1 + str2 + str3
     */
    public static String connectString(String str1, String... str2) {
        // str1 + str2 + str3
        StringBuffer assuredSb = new StringBuffer();
        assuredSb.append(BLANK);
        if (null != str1) {
            assuredSb.append(str1);
        }
        if (null != str2) {
            for (String str : str2) {
                assuredSb.append(str);
            }

        }
        return assuredSb.toString();
    }


    /**
     * コレクション判空を行う
     * @param collection コレクション
     * @return true:空|false:非空
     */
    public static boolean isEmpty(Collection<?> collection) {

        return null == collection || collection.isEmpty();
    }


    /**
     * マップ判空を行う
     * @param map マップ
     * @return true:空|false:非空
     */
    public static boolean isEmpty(Map<?, ?> map) {

        return null == map || map.isEmpty();
    }


    /**
     * 配列判空を行う
     * @param array 配列
     * @param <T> タイプ
     * @return true:空|false:非空
     */
    public static <T> boolean isEmpty(T[] array) {

        return null == array || array.length == 0;
    }


    /**
     * 値比較
     * @param a 比較パラメータ１
     * @param b 比較パラメータ２
     * @return 比較結果
     */
    public static boolean assertEqual(String a, String b) {

        boolean ret = false;
        if (isEmpty(a) && isEmpty(b)) {
            ret = true;
        } else if (!isEmpty(a) && !isEmpty(b) && a.equals(b)) {
            ret = true;
        }
        return ret;
    }
}
