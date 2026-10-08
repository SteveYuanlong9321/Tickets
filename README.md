
# Tickets App

**Tickets** 是一款面向 Android 的本地电子票据管理应用，核心理念是：

> **我的设备，我的票**

Tickets 用于在自己的设备上整理和管理数字票据，并提供设备之间的票据传递与实时状态展示。

## 主要功能

### 电子票据管理
支持多种常见数字票据类型，包括：

- 车票
- 机票
- 演出票
- 门票
- 取餐码
- 取件码

票据可以在设备本地保存和管理，方便集中查看重要的数字凭证。

### 设备间传票
Tickets 支持在用户主动操作下，将票据发送到另一台设备。

用户可以自行选择数据传输方式：

- Google Nearby
- Wi-Fi Direct
- Bluetooth

NFC 和二维码主要用于建立分享会话与确认，实际票据数据使用用户选择的数据传输通道发送。

传票过程需要用户主动发起和确认，不会在后台自动向附近设备发送票据。

### 智能地铁 Beta
v7.0.0 加入持续开发中的“智能地铁”测试版功能。

支持 GPS 实时行程跟踪、站点状态识别、区间进度计算、手动到站推进、多城市线路与换乘数据，以及线路颜色自动匹配。

当前测试版支持：

- 中国城市：包含中国大陆、香港、澳门相关数据范围内的部分城市
- 台湾：统一以“台北”作为城市入口，包含台北捷运、桃园机场捷运、新北环状线
- 美国城市：7 个城市

智能地铁目前仍属于 Beta 测试功能，具体城市和线路支持范围会持续更新。

### 实时通知
Tickets 目前保留三路实时通知能力：

- Android Live Update
- Samsung Now Bar / 实时窗口
- Xiaomi SuperIsland

实时通知可以展示行程状态、当前站、下一站、进度和倒计时等信息。

## 本地优先

Tickets 以本地设备为核心保存和处理票据信息。

OCR 和条码识别用于帮助用户从票据图片中提取内容；设备间传票只在用户主动发起时进行。

部分可选功能使用第三方技术服务，例如 Firebase Cloud Messaging 和 Google Play services。相关第三方服务可能按照其自身的隐私政策处理运行所需的技术信息。

## 当前版本

**v7.0.0**

当前版本重点：

- 智能地铁 Beta 更新
- 更多城市与线路数据
- GPS 实时行程跟踪
- 站点状态识别
- 区间进度计算
- 手动“我已到达下一站”
- Android Live Update
- Samsung Now Bar
- Xiaomi SuperIsland
- 台湾轨道交通统一以台北作为入口

## 应用语言

**简体中文**

## 官方资源

官方网站：  
https://steveyuanlong9321.github.io/Tickets/

GitHub：  
https://github.com/SteveYuanlong9321/Tickets

GitHub Releases：  
https://github.com/SteveYuanlong9321/Tickets/releases

隐私政策：  
https://steveyuanlong9321.github.io/Tickets/privacy.html

温馨提示：7.0.0版本的源代码因为新版本修复和开发时已经被新代码覆盖了，故此库里的7.0.0版本的源代码属于正式版Apk的提取代码，建议仅作为参考和学习，但也欢迎直接使用！
---

Tickets App · Version 7.0.0
