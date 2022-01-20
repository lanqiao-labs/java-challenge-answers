mkdir /home/shiyanlou/testdir
wget https://labfile.oss.aliyuncs.com/courses/3485/gh_1.6.1_linux_amd64.deb
mv gh_1.6.1_linux_amd64.deb /home/shiyanlou/testdir/gh.deb
cd /home/shiyanlou/testdir
ls
sudo dpkg -i gh.deb