/**
 * 食べ物全般を表すクラス(食べ物の設計図)
 * このクラスはTaiyaki.javaとMedamayaki.javaのスーパークラス(親クラス)
 * classはオブジェクトの設計図と覚える
 *
 * このクラスで覚えて欲しいこと
 * - 継承(superクラス)
 * - getterの使い方 → Human.java(呼ぶ側)とセットで使い方を覚える
 *    - 戻り値
 */
public class Food {
	// 定数
	private static final int KAIHUKU_VALUE_MAX = 1000;
	private static final int KAIHUKU_VALUE_MIN = 1;

	// 属性 (通常 メンバ変数[※1] と呼ばれる)
	private int kaihukuValue;
	private String name;


	public Food(int kaihukuValue, String name) {

		// 不適切な値が入ってきた場合は落とす
		validate(kaihukuValue, name);

		// コンストラクタの説明は割愛 → Human.javaのコンストラクタを参照
		this.kaihukuValue = kaihukuValue;
		this.name = name;

		System.out.println(name + "(回復バリュー:" + kaihukuValue + ")ができたよー。めしあがれ！");
	}

	private void validate(int kaihukuValue, String name) {
		// validate kaihukuValue
		if (kaihukuValue < KAIHUKU_VALUE_MIN) {
			throw new IllegalArgumentException("kaihukuValue min is " + KAIHUKU_VALUE_MIN);
		}

		if (kaihukuValue > KAIHUKU_VALUE_MAX) {
			throw new IllegalArgumentException("kaihukuValue max is " + KAIHUKU_VALUE_MAX);
		}

		if (name == null
			|| name.length() == 0
			|| name.trim().length() == 1) {
			throw new IllegalArgumentException("name is empty");
		}
	}

	// メンバ変数[※1]「private kaihukuValue」のgetter
	// Human.javaのeat()メソッド内(呼び出す側)で使ってる → Human.javaのeat()メソッドを見てみる
	public int getKaihukuValue() {
		return kaihukuValue;
	}
}
