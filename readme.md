# one0938 Learning Box

Welcome to the learning box! This is my attempt at making an all-in-one beginners guide to FTC 
software development in android studio. I'm going to talk through external libraries, best practices
for organisation, as well as including full sample OpModes for common drivetrains and mechanisms.

If you're just starting, I would recommend reading through this document as a quick introduction to
the basics of android studio, and some major details about using it for FTC programming. If this is
your first time programming with Android Studio for FTC, don't download this repository until the
Getting Started section of this document tells you to. (This document is organised kind of like a
tutorial.)

## Android Studio

Android Studio is one of 3 different ways to program for FTC robots. The other two are FTC Blocks
and OnBotJava, both of which are run natively on the robot controller. These are easier methods of
programming and recommended for beginners in FTC robotics, but once you start diving into more
complicated systems and solutions, they fall short.

Android Studio is an environment designed to create apps for the Android operating system developed
by Google. When you are using it for FTC, you will be using the FTC SDK which is a broken down copy
of the robot controller app on your control hub/android phone on the robot. This allows you to build
your code to the robot controller using Android Debug Bridge. It also means you can also
install external modules like FTCLib to your robot controller, and use them in your OpModes in
addition to the already included parts of the FTC app.

### Getting Started

To get started with Android Studio, you need to install Android Studio. Google distributes the IDE
for free on their website which can be found here:

https://developer.android.com/studio

Their website may change over time but hopefully they maintain this aspect: Scroll down to the
section of the page labeled "Android Studio Downloads". Here, you will find multiple options to
download. Depending on what your school's rules are, you may or may not be able to install Studio
by some methods. On windows, if your computer has no administrative limitations, you can use the
executable (file ending in `.exe`) to install it. If you aren't able to gain administrative access,
you will need to use the zip archive (file ending in `.zip`) to install. Using the executable, you
can follow the steps in the setup wizard to install Studio. If you're using the zip archive, here is
my recommended method of installation:

1. Unzip the archive by right clicking it in your file explorer and selecting "Extract All". You
will then need to use the dialog box that appears to choose the destination for your extracted 
files. I recommend choosing a folder on your computer that you don't access frequently. For ease of
access, I recommend selecting the "Show extracted files when complete" option.
2. When the archive has been successfully extracted, locate the file `studio64.exe`. Depending on
where you put the extracted folder, the file location should look something like
`*\android-studio\bin\studio64.exe`. I recommend right-clicking this file and selecting "Create
shortcut".
3. Copy the new shortcut file that is created to your desktop. You can now double click this shorcut
any time you want to open Studio.

If you are on a MacBook, you only need to differentiate between ARM and x86 based devices. All 
MacBooks released following and including those released in November of 2020 use ARM, as well as
iMacs released after April of 2021. MacBooks and iMacs released before those dates will need the
non-ARM version of the download.

Chromebooks also have support for Studio, but it gets complicated. If you are able to enable Linux
under the developer settings on your chromebook, then you can use
[this article] (https://developer.android.com/topic/arc/development-environment) to install it using
the chromebook download of Studio.

### Beginners Guide
When you first open Android Studio, you may be greeted with multiple prompts. Feel free to ignore
them. After all the popups are gone you will be greeted by an interface you will become VERY
familiar with. The top bar has a hamburger menu in the top left corner. When you click on it, the
top bar will fill in with your typical options from file to help. I recommend you select "Help" and
explore some of the options from "Android Studio Help" to "Keyboard Shortcuts" to familiarise
yourself with the IDE and its functions. (Yes this is a cop-out.)

## FTC Software Development Kit (SDK)

The FTC SDK is essentially a development copy of the Robot Controller app. This is the project you 
will be using inside of Android Studio to do all of your programming.

### Getting Started

To download the SDK, click [here] (https://github.com/FIRST-Tech-Challenge/FtcRobotController) for
the FTC Robot Controller GitHub page. You have two options here. You can clone this repository to 
your own computer using github for desktop or you can download the repository and edit it directly.
If you are on a team of multiple programmers working on the your robot, I would recommend cloning
and sharing the repository between each other. I will describe how to do both

#### Zip Download and Direct Edit

Here, you will want to select "Code" then "Download ZIP". This
will start downloading the SDK in an archive folder. When the download is complete, you will want to
extract the archive, storing it wherever you want your project to be saved.

#### GitHub Clone

Open GitHub Desktop and select `File>Clone a Repository`. Select URL and on the GitHub page of the 
Robot Controller, select `Code` and copy that URL into the prompt in GitHub Desktop. Change your
local path to wherever you want to repository to be stored. A loading bar will appear as GitHub
clones the repository onto your computer. You can now use the GitHub interface to manage commits and
view version history for your project. You can also add editors and work together on your programs.

#### Both

In Android Studio, go to `File>Open` and select the root folder of the repository. The project will
now open in Android Studio and we can get into the meat of this portion of the Learning Box.

Please Note: if you are prompted to perform a Gradle sync, do it. This is when Android Studio
downloads all the dependencies of the project that are necessary for the app to be installed and for
easy programming and integrated documentation of the FTC SDK.

### SDK Structure

By default, Android Studio will display your project as a breakdown into 3 sections that you'll need
to understand. This breakdown style is called "Android" and is one of a few different views for your
project.

#### FtcRobotController

This is the portion of the SDK that runs your programs on the robot. You won't need to do anything
to this module.

#### TeamCode

This is where you'll spend most of your time. The TeamCode module is where you write all of your
OpModes and modules. It's also the portion of the SDK that builds your code to your robot
controller.

#### Gradle Scripts

This sections stores all of the settings and dependency links for your application. In order to add
external dependencies, you'll be editing these scripts, adding new dependencies and tweaking
configuration settings.

### Where do I put my code?

The fun part! Of course! Inside the TeamCode module, there are several folder-like structures called
packages. These have dropdown boxes that you can click to show the contents of. The package that
will contain your OpModes and modules is `java.org.firstinspires.ftc.teamcode` That's where this
package goes. Download the one0938LearningBox package, extract its contents, and copy it to that
destination. You can access the project files to find this directory by navigating to
`*\TeamCode\src\main\java\org\firstinspires\ftc\teamcode` in your file manager. When you copy the 
package into that folder, it should appear in Android Studio.

Feel free to start looking through the learningToOpMode package where you'll start learning more
about the inner-workings of programming your robots.