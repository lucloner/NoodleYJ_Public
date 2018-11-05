@echo off
echo 本程序为u盘安装后网络部署版本
echo 命令格式为:setup_without_APK+空格+远程设备地址或USB+空格+注册文件License.zip
pause
call setup.bat %1 NOAPK %2
