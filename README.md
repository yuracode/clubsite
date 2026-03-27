# Clubsite

クラブ活動のためのWebサイトアプリケーションです。

## 概要

Clubsiteは、クラブの情報管理、投稿共有、イベント管理などを行うための総合的なWebサイトプラットフォームです。会員による投稿、スケジュール管理、トーナメント管理、お気に入り機能などが利用できます。

## 主な機能

- **ユーザー認証・管理**: ログイン・登録機能とセキュアな認証
- **投稿機能**: クラブの情報やニュースを共有
- **お気に入り**: 投稿をお気に入りに登録
- **スケジュール管理**: クラブの予定を一元管理
- **トーナメント管理**: 大会や競技結果を記録
- **カレンダー表示**: イベントスケジュールを視覚化
- **ファイルアップロード**: アバター画像などの管理

## 技術スタック

- **フレームワーク**: Spring Boot 3.2.3
- **言語**: Java 17
- **ビルドツール**: Gradle
- **フロントエンド**: Thymeleaf, HTML/CSS
- **データベース**: H2 Database
- **ORM**: MyBatis
- **セキュリティ**: Spring Security
- **その他**: Lombok

## セットアップ

### 前提条件

- Java 17以上
- Gradle（またはGradleウェッパー）

### インストール

1. リポジトリのクローン
```bash
git clone <repository-url>
cd clubsite
```

2. 依存関係のインストール
```bash
./gradlew build
```

3. アプリケーションの起動
```bash
./gradlew bootRun
```

アプリケーションはデフォルトで `http://localhost:8080` で起動します。

## 使用方法

### H2コンソール

データベースを確認するには、以下にアクセス:
```
http://localhost:8080/h2-console
```

## プロジェクト構造

```
clubsite/
├── src/
│   ├── main/
│   │   ├── java/com/example/clubsite/
│   │   │   ├── config/          # Spring設定クラス
│   │   │   ├── controller/      # Webコントローラー
│   │   │   ├── mapper/          # MyBatisマッパーI/F
│   │   │   ├── model/           # エンティティクラス
│   │   │   └── service/         # ビジネスロジック
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql       # DB スキーマ
│   │       ├── data.sql         # 初期データ
│   │       ├── mapper/          # MyBatisマッパーXML
│   │       ├── static/          # 静的ファイル（CSS、画像）
│   │       └── templates/       # Thymeleafテンプレート
│   └── test/                    # テストコード
├── build.gradle                 # Gradle設定
└── settings.gradle              # プロジェクト設定
```

## ビルド・テスト

### ビルド
```bash
./gradlew build
```

### テストの実行
```bash
./gradlew test
```

### 開発用サーバー起動
```bash
./gradlew bootRun
```

## ライセンス

このプロジェクトはオープンキャンパス用です。

## お問い合わせ

何かご質問やバグ報告がありましたら、ご連絡ください。
