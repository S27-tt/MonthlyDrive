# 運転日報アプリ「MonthlyDrive」
会社で使用する社有車の運転日報を作成できるサイトとなります。
日付、メーター等を情報入力画面から入力することで、運転日報が作成できます。

＜運転日報画面＞
<div align="left">
<kbd><img width="600" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/7ce4231f-9f6f-4d99-9af6-c199489ac39c">
</kbd>
</div>
＜出発情報登録画面＞
<div align="left">
<kbd><img width="197" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/e02afa49-350c-4f91-bac2-55ba9141c584">
</kbd>
</div>
<br>
＜到着情報登録画面＞
<div align="left">
<kbd><img width="196" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/2dbeffd1-75bf-452b-a674-e6198d1bb391">
</kbd>
</div>

## URL
https://myapp230701.mydns.jp/monthlydrive

# 使用技術
- Java 16.0.2
- Spring boot 2.7.16
- PostgreSQL 13.11
- AWS
    - EC2

# 機能一覧
- 登録機能
    - 日付、運転者、用途、目的地、出発/到着時間、私用料金、開始/終了メーター
- 自動計算機能
    - 運転時間計算、走行距離計算

# テスト
