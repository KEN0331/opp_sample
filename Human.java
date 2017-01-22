/**
 * 人間を表すクラス(人の設計図)
 * classはオブジェクトの設計図と覚える
 *
 * このクラスで覚えて欲しいこと
 * - メンバ変数(属性)
 * - コンストラクタ(初期化)
 *    - 引数
 * - メソッド
 *    - 引数
 * - getterの使い方 → Food.java(呼ばれる側)とセットで使い方を覚える
 *    - 戻り値
 */
public class Human {

	// 定数
	private static final int HP_MAX = 10000;
	private static final int HP_MIN = 1;

	// 属性 (通常 メンバ変数[※1] と呼ばれる)
	private int hp;
	private String name;

	// オブジェクトnew初期化 (通常 コンストラクタ[*2] と呼ばれる)
	public Human(int hp, String name) {

		// 不適切な値が入ってきた場合は落とす
		validate(hp, name);

		// 「this.hp = hp;」部分の解説
		// ①左辺のthisはHumanのobjectを示す → つまりthis.hpは メンバ変数[※1]のhpを参照している
		// ②右辺のhpは引数を参照している

		// 「public Human(int hp) {」部分の解説
		// ③引数の(int hp)は呼び出す側から「new Human(20)」のようにオブジェクトを生成する時に
		// 値を初期値としてhpを渡すために渡すために数字を渡せる箱を用意している

		// ※ 渡された値(③で説明した引数 int hp)は
		// 呼び出される側のHumanのコンストラクタ内(まさにここ)では
		// ローカル変数hpとして扱える
		this.hp = hp;
		this.name = name;

		// newで生成されるタイミングで毎回ここを通るはずだから「nameさんがこの世に生を受けた」てきなログをここで吐くようにして見る
		System.out.println(name + "がこの世に生を受けた。" + name + "の偉大な冒険がはじまる。");
	}

	private void validate(int hp, String name) {
		// validate hp
		if (hp < HP_MIN) {
			throw new IllegalArgumentException("hp min is " + HP_MIN);
		}

		if (hp >= HP_MAX) {
			throw new IllegalArgumentException("hp max is " + HP_MAX);
		}

		if (name == null || name.trim() == "") {
			throw new IllegalArgumentException("name is empty");
		}
	}

	// eat() だけだと何個も食べた時に「eat(taiyaki); eat(taiyaki); eat(taiyaki);」みたいに書くのだるいから
	// リスト形式で複数渡す方法を覚えると良い
	public void eatSome(Food[] foodList) {
		// 「for (クラス名 オブジェクト : 繰り返したいリスト) {」
		// という構成で{}内に繰り返しのコードを書ける

		// List<リスト内のオブジェクトのクラス> (Listはjavaが提供するクラスなので覚える系)
		// → List<Food>はFood型(Foodクラス)のオブジェクトが複数入っている
		for (Food food : foodList) {
			// foodListは [Food food, Food food, Food food, Food food...] みたいに
			// Food型のオブジェクトが複数入っているものだと思えば良い

			// (Food food : foodList) ってやるとfoodListの中身を
			// 1個目から順番にfoodっていう変数に入れてくれる(よくfoodListを「回す」と表現する)

			// ここで[Food food, Food food, Food food, Food food...]のイメージを思い出す
			// つまりeat(food)は↑の数だけ実行される
			eat(food); // ※ このeat()メソッドはeatSomeメソッドの下に一個食べる時のメソッドとして用意したもの(回復バリューを足してる)
			           //→ 「public eat(Food food) {」を見てみる

			// ④printlnで確認すると分かりやすい
			// → 「public eat(Food food) {」内でprintlnしたから↑の「eat(food)」が呼ばれる回数分「nameが飯を食ってkaihukuValue回復した」ってでる
		}

		// ここではHumanが何かを食べた時にいくつ食べたかをprintlnしてみる
		System.out.println(this.name + "さんが全部で" + foodList.length + "個のFoodを食べた");
		// ↑よく見るとthis.nameでHumanコンストラクタの①で説明したのと同じようにHumanクラスの メンバ変数[※1] を参照してHumanの名前を引っ張ってきてる
		// Humanコンストラクタ[*2] のところで「this.name = name;」って人の名前(name)をやって初期化していたことを思い出す

		System.out.println("さあ旅の続きだ！" + name + "の旅は終わらない");
	}

	// 一個食べたい時はこれを使う
	public void eat(Food food) {
		// Food型のオブジェクトはprivate int hpKaihukuValueを持ってるはず！(自分で定義したから)
		// getterをFoodクラス側に用意してFoodクラス外からでも
		// food.getHpKaihukuValue()」でアクセスできるようにする → Food.javaを見てみる
		hp += food.getKaihukuValue();

		// 「public eatSome(List<Food> foodList) {」の④で説明したログ
		System.out.println(name + "が飯を食って" + food.getKaihukuValue() + "回復した！");
	}

	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}
}
