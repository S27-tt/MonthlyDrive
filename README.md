# 運転日報アプリ「MonthlyDrive」
会社で使用する社有車の運転日報を作成できるサイトとなります。  
日付、メーター等を情報入力画面から入力することで、運転日報が作成できます。

＜運転日報画面＞
<div align="left">
<kbd><img width="600" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/7ce4231f-9f6f-4d99-9af6-c199489ac39c">
</kbd>
</div>
<br>
＜出発情報登録画面＞
<div align="left">
<kbd><img width="197" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/a461db02-b893-4821-8b87-27fa762603f2">
</kbd>

</div>
<br>
＜到着情報登録画面＞
<div align="left">
<kbd><img width="196" alt="image" src="https://github.com/S27-tt/MonthlyDrive/assets/131981423/055e6a48-fb74-42bd-9e38-3079c9922543">
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
    - 日付
    - 運転者
    - 用途
    - 目的・行く先
    - 出発/到着時間
    - 私用料金
    - 開始/終了メーター
- 自動計算機能
    - 運転時間計算
    - 走行距離計算
- 画面説明
    - 運転日報画面
        - 上記URLを開くと初めに表示されるページ。
        - 表示項目
            - 日付
            - 運転者
            - 用途
            - 目的・行く先
            - 出発時間
            - 到着時間
            - 運転時間
            - 私用料金
            - 開始メーター
            - 終了メーター
            - 走行距離
            - 到着/削除
            - 出発登録  
          出発情報登録画面、到着情報登録画面より得た情報が  
          画面へ更新される。  
          「出発登録」ボタンを押すことで、出発情報登録画面へ移り、  
          出発情報登録後、「到着」ボタンを押すことで、到着情報登録画面へ移る。 
    - 出発情報登録画面
        - 運転を出発する際に、情報を登録する画面
        - 表示項目
            - 出発時間
            - 運転者
            - 用途
            - 目的・行く先
            - 開始メーター 
    - 到着情報登録画面
        - 運転を終了する際に、情報を登録する画面
        - 表示項目
            - 到着時間
            - 終了メーター
            - 私用料金

