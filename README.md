
# groovy-framework-libs

 The repository contains the CI/CD framework codebase.

 This library used here: https://github.com/gitmnd/dynamic-docker-image-in-k8s-ci-cd

 Check below for Jenkins related pluggins and other info.


## pluggins used

``` 
aws-credentials.bak
aws-credentials.jpi
aws-device-farm.jpi
aws-java-sdk-ec2.bak
aws-java-sdk-ec2.jpi
aws-java-sdk-minimal.bak
aws-java-sdk-minimal.jpi
bouncycastle-api.jpi
filenames.txt
generic-webhook-trigger.jpi
jackson2-api.jpi
jaxb.jpi
joda-time-api.jpi
kubernetes-cli.jpi
kubernetes-client-api.jpi
kubernetes-credentials.jpi
multibranch-scan-webhook-trigger.jpi
powershell.jpi
sshd.jpi
```

## Credentials used in Jenkins

You can upload your kubectl config for different environments as Secret file.


![img_10.png](images%2Fimg_10.png)

## Configure shared library

Path: 
Dashboard > Manage Jenkins >System

![img_2.png](images%2Fimg_2.png)
![img_9.png](images%2Fimg_9.png)

## Tools configuration

![img_5.png](images%2Fimg_5.png)
![img_6.png](images%2Fimg_6.png)
![img_7.png](images%2Fimg_7.png)
![img_8.png](images%2Fimg_8.png)



## Trouble shooting

If you see below error in pipeline,

![img_1.png](images%2Fimg_1.png)

this could be because of , 
If you choose pipeline to execute in Groovy sandbox which has restriction in some aspects for security considering. Like using new keyword, using static method.

Add the restriction to whitelist in jenkins > Manage jenkins > In-process Script Approval

![img.png](images%2Fimg.png)
