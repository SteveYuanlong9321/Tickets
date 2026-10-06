# Tickets F-Droid Repository

Tickets 使用独立的 F-Droid 第三方仓库发布完整 APK，不改变主应用的 FCM、Google Nearby 或设备间传票功能。

仓库会由 GitHub Actions 自动从最新 GitHub Release 获取 APK、生成 F-Droid 索引并更新 `fdroid-repo` 分支。

用户添加仓库时使用：

https://raw.githubusercontent.com/SteveYuanlong9321/Tickets-App/fdroid-repo/fdroid/repo?fingerprint=643CF127A884E116260C0CFE40B8FA0AC3B1CE2C1AE0685F354EF34E503BAD8A

首次启用前需要在 GitHub 仓库的 Settings → Secrets and variables → Actions 中创建 Repository secret：

FDROID_REPO_SECRET

该 secret 包含 F-Droid 仓库签名密钥及密码，仅用于 GitHub Actions 生成和签名仓库索引。