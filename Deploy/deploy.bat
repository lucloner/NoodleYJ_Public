@echo off
if "%1"=="" goto :help
if "%2"=="" goto :help
if not exist platform-tools\adb.exe goto :help
echo 即将安装文件,由于安装包较大需要刷新临时目录
echo 请确定机器已经重启过,安装出现错误信息可重试
echo 网络安装出现错误后可能需要U盘导入NoodleYJ.apk
echo 按Ctrl+C终止..
pause
platform-tools\adb root
platform-tools\adb remount
if exist bootanimation.zip platform-tools\adb push bootanimation.zip /system/media/
platform-tools\adb install %1
platform-tools\adb push %2 /sdcard/License.zip
platform-tools\adb shell pm disable com.android.launcher3
platform-tools\adb reboot
echo 传送正常,注册成功后还需要再次重启才能使用
goto :end
:help
	echo 本程序需要platform-tools\adb.exe,另外需要安装adb驱动
	echo 请输入:deploy+空格+NoodleYJ安装包.apk+注册文件License.zip
	pause
	goto :over
:end
	echo deploy_OK
	pause
:over