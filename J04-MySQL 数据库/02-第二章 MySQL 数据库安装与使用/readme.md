安装步骤参考如下 ：
# 卸载移除 
sudo apt-get remove mysql-common -y 
sudo apt-get autoremove -y 
dpkg -l|grep ^rc|awk '{print$2}'|sudo xargs dpkg -P  
# 下載
wget https://labfile.oss.aliyuncs.com/courses/3232/mysql-server_5.7.32-1ubuntu16.04_amd64.deb-bundle.tar
# 解压安裝依赖
tar -xvf mysql-server_5.7.32-1ubuntu16.04_amd64.deb-bundle.tar
sudo apt install -y libtinfo5  libmecab2
# 安装数据库
sudo dpkg -i mysql-common_5.7.32-1ubuntu16.04_amd64.deb
sudo dpkg -i mysql-community-client_5.7.32-1ubuntu16.04_amd64.deb
sudo dpkg -i mysql-client_5.7.32-1ubuntu16.04_amd64.deb
sudo dpkg -i mysql-community-server_5.7.32-1ubuntu16.04_amd64.deb
