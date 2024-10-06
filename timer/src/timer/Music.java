package timer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	public static int i = 0;
	//ランダム実行時はここをコメントアウト
	//Time＿ver2にもいじる箇所があるため注意。

	public static void music() throws Exception {
		String[] s = new String[255];
		//int i = new java.util.Random().nextInt(s.length);
		//ランダム実行時にはここをアクティブに

		s[0] = "動画【星のカービィ】“カービィダンス（①ゴール）１up付き”　効果音.wav";
		s[1] = "【ドラクエ】レベルアップ音.wav";
		s[2] = "勝利のファンファーレ.wav";
		s[3] = "名探偵コナン　扉　gb素材.wav";
		s[4] = "伝説のポケモンシルエットクイズ.wav";
		s[5] = "【星のカービィ スーパーデラックス】 カービィ凱旋.wav";
		s[6] = "maou_short_14_shining_star.wav";
		//上記を参考に音楽ファイルを追加してください。

		Clip clip = createClip(new File(s[i]));
		clip.start();
		Thread.sleep(25000);//このミリ秒流れる。1000 = 1秒 
		clip.close();
		//ここで再生メソッドの呼び出し
	}

	public static Clip createClip(File path) {
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)) {

			//ファイルの形式取得
			AudioFormat af = ais.getFormat();

			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class, af);

			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip) AudioSystem.getLine(dataLine);

			//再生準備完了
			c.open(ais);

			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
}