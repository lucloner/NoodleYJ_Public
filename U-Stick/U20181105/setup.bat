@echo off
echo 本程序为安装入口,证网络可达或USB调试模式已经搭建好
echo 默认adb通讯端口为5555
if "%1"=="" goto :help
if not exist platform-tools\adb.exe goto :help_adb
platform-tools\adb kill-server
if "%1"=="USB" goto :usb
platform-tools\adb connect %1 | findstr "connected"
if %errorlevel% NEQ 0 goto :help
echo 连接成功开始部署
:usb
	echo 即将安装文件,由于安装包较大需要刷新临时目录
	echo 请确定机器已经重启过,安装出现错误信息可重试
	echo 网络安装出现错误后可能需要U盘导入NoodleYJ.apk
	echo 出现apk安装失败请重起设备后再试
	echo 按Ctrl+C终止..
	pause
	platform-tools\adb root
	platform-tools\adb remount
	echo 安装到 %1
	if not exist bootanimation.zip goto :step2
	platform-tools\adb push bootanimation.zip /system/media/
	echo 开机logo:bootanimation.zip  ... ok
:step2
	if "%2"=="" goto :finish
	if "%2"=="NOAPK" goto :step3
	if not exist %2 goto :help
	platform-tools\adb shell rm /sdcard/NoodleYJ.apk
	platform-tools\adb push %2 /sdcard/NoodleYJ.apk
	platform-tools\adb shell pm install -t -r /sdcard/NoodleYJ.apk | findstr "Success"
	if %errorlevel% NEQ 0 goto :step2_err
	echo 主程序NoodleYJ.apk文件:%2  ... ok
	goto :step3
:step2_err
	echo 主程序NoodleYJ.apk文件:%2  ... 失败,已跳过
:step3
	if "%3"=="" goto :finish
	if not exist %3 goto :help
	platform-tools\adb push %3 /sdcard/License.zip
	echo 离线授权License.zip文件:%3  ... ok
:finish
	echo 现在进入完成阶段,将锁定/禁用起动器,按Ctrl+C终止..(可能需要手动重启)
	pause
	platform-tools\adb shell pm disable com.android.launcher3
	platform-tools\adb reboot
	echo 部署完成
	goto :end
:help_adb
	echo adb未找到！
:help
	echo 错误！
	echo 请输入:setup+空格+远程设备地址或USB+空格+NoodleYJ安装包.apk或NOAPK+注册文件License.zip
	echo 举例:setup 192.168.1.50
	echo 举例:setup 192.168.1.50 NoodleYJ.apk License.zip
	echo 举例:setup USB NOAPK License.zip USB连接,跳过安装,仅注册
	goto :over
:end
	echo 部署完成如需要在线注册请于设备上输入序列号并选择在线激活,(激活后需要重启)
	echo OK！
:over
	echo 按任意键退出...
	pause > nul
