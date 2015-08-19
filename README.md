INTRODUCTION
Welcome to Mara Web Automation project. This project is built using TestNG framework and makes use of Selenium Web Driver.
http://docs.seleniumhq.org/

Instructions to Setup this project
Pre-Requisites
1. Install JDK
2. Sharath will update this section


GIT Instructions
1. To clone this project on your system run the following command ( Ensure Git is installed on the machine and also ensure you have read-write access to this project. Talk to Bharat for more details)
Create a folder called Automation on the system and the run the following command from terminal
cd Automation
git clone --progress -v git@repo1.mara.com:mm-web-testing

- You should see a folder "mm-web-testing" created under Automation folder

2. Once the project is cloned, run the following commands to check you are on the right branch
cd mm-web-testing
git branch ( You should see something like this printed on the terminal)
maratests-MacBook-Pro:mm-web-testing maratest$ git branch
* master

3. When you make/add new tests to the project , you need to run the following commands to push your changes to server
git pull origin master ( This is to make sure you have pulled all recent changes from the server before you push your changes to server)
git status ( To ensure all the changes you made get reflected)
git add "file" ( This command adds all files that needs to be committed and pushed to server)
git commit -am "Committing new tests to the project" ( This commits all files that will be pushed to server)
git push origin master ( This command finally pushes all the files to the remote server)

4. To create your own branch , run the following commands
git branch ( Ensure you are in master branch)
git checkout -b <yourname/modulename/testcasename> ( This creates your own branch)
git branch ( Ensure you are in your branch)
After doing your changes--> git add, commit


5. Best practices
a. Its always good to use 'git status' command to check at what stage is your file.
b. Its always good to pull all the latest changes from server before you start work on new tests. This avoids conflicts
c. Avoid pushing files that are local to your machine. 




