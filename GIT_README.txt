Steps to Configure git and pull/push code
1. Install Git 
2. Create github account and repository in git
3. Create local directory and copy existing project or any file, this directory will be called as local git repository
4. Now go to created directory and right click and open Git Bash Here
5. Lets initialise th directory for git ... Issue command git init
6. To see changes issue command .... git status
7. Once we have made any changes or added new file then issue command ... git add file.txt or git add project_name
8. Once added issue git commit -m "Comments for committing"
9. Now its time to link git repo to github account 
     1. First configure the username
	 Issue command ...git config --global user.username xyz123user
	 
	 2. Now lets link github repository branch to local repository
	 Issue command ...git add origin "https Repo link "
	 if above does not work then try below steps
	 
	       1. Copy the ssh url of github account created repository
		   2. Issue command ..... git remote set-url origin copied_repo_path_https  or git remote set-url origin copied_repo_path_https
		   3. Issue command ..... git push origin master or git push -u origin master
		   if the 3rd step throws any error like permission denied then we need to create ssh key follow below steps(Because we are connecting github over ssh)
		   1. Command.. git config --get remote.origin.url (this will display the ssh url which was set in above step 2
		   2. Issue command to genrate ssh key....ssh-keygen -t rsa -b 4096 -C "useremail@gmail.com"
		   3. It will ask to give file name and passphrase(Remember the passphrase)
		       [ Two files will be created one as private key and other as public key ]
		   4. Once its done lets add ssh key to ssh agent using below command
		   5. Issue command ssh-add ~/.ssh/git_ssh_key(File name of ssh key) , after hitting enter it will ask passphrase.
		   6. Once correct passphrase is entered , key is added succesfully 
		   7. Now copy the public key and add it in your git acc settings---add ssh key option
		   8. Once added issue below command
		   9. git push origin master
		   10. Will see changes will be pushed , we can verify by visiting git hub acc repo
		   11. Issue command git config --list [to see config]
		   12. To take any changes made using pull request issue below command
		   13. Lets add remote url as upstream master ... git remote add upstream github_acc_url(ssh)
		   14. Now update local repo.... git pull upstream master

		   15. Hello Hi
		   