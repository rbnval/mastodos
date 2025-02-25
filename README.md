![Pink version of the Mastodon for Android launcher icon](mastodon/src/main/res/mipmap-xhdpi/ic_launcher_round.png)

# Mastodos

> A fork of the [official Mastodon Android app](https://github.com/mastodon/mastodon-android) adding important features that are missing in the official app and possibly won’t ever be implemented, such as the federated timeline, unlisted posting, bookmarks and an image description viewer.

[![Download latest release](https://img.shields.io/badge/dynamic/json?color=d92aad&label=download%20apk&query=%24.tag_name&url=https%3A%2F%2Fapi.github.com%2Frepos%2Fsk22%2Fmastodon-android-fork%2Freleases%2Flatest&style=for-the-badge)](https://github.com/sk22/mastodos/releases/latest/download/mastodos.apk)

---

## Key features

### **Unlisted posting**

**Allows you to post publicly without having your post show up in trends, hashtags or public timelines (i.e., in the tabs “Local”, “Community” and “Posts”).**

When posting with Unlisted visibility, your posts will still be publicly accessible in your profile. They will also be shown in people’s Home timelines, but only if they follow you or someone they follow reposted/replied to your post.
  
The Mastodon documentation has some more information about [Unlisted posting](https://docs.joinmastodon.org/user/posting/#unlisted) and [Public timelines](https://docs.joinmastodon.org/user/network/#timelines).

### **Federated timeline**

**This allows you to chronologically see all Public posts from people on all other Fediverse instances your home instance is connected to.**

Despite being one of the main features of federated social media, the Federated timeline wasn’t included in the official Mastodon app – supposedly, because this conflicts with Google’s safety requirements for apps on the Play Store.
  
That’s one of the reasons why choosing a small, **well-moderated instance is important**. Instance admins and moderators should always make sure to ban abusive users and stop federating with instances who platform them. On well-moderated instances, the Federated timeline can be a welcoming place to meet new people!

### **Image description viewer**

**Allows you to quickly check whether an image or video has an alternative text attached to it.**

This is important to **ensure the content you’re sharing is as accessible as possible** to people who can’t see the images and rely on software to read back the provided content descriptions. Thankfully, it’s quite common for people on the Fediverse to provide such alt texts, and hopefully things stay this way!

### **Pinning posts**

**This lets you can highlight important posts on your profile. A dedicated “Pinned” tab in people’s profiles shows all the posts they pinned.**

On the Fediverse, it’s quite common for people to pin posts they want others to read before following them. You can pin/unpin posts yourself by clicking the `⋯` button in the top right corner of your posts.

### **Bookmarks**

**They allow for quickly saving posts and viewing them through the Bookmarks button on the top right of your profile.**

To bookmark a post, press the button between the Favorite and Share buttons on the bottom of the post. Bookmarks are saved privately, so the post authors won’t know you saved their post – the list of bookmarked posts is only visible to you.

## Installation

**Press the download button above to download the APK. Open the downloaded file on your Android device to install it. Mastodos will automatically notify you about new updates inside the app.**

To install this app on your Android device, download the [latest release from GitHub](https://github.com/sk22/mastodos/releases/latest/download/mastodos.apk) and open it. You might have to accept installing APK files from your browser when trying to install it. You can also take a look at all releases on the [Releases](https://github.com/sk22/mastodos/releases) page.

Mastodos makes use of [Mastodon for Android](https://github.com/mastodon/mastodon-android)’s automatic update checker. Mastodos will check for new updates available on GitHub and offer to download and install them. You can also manually press “Check for updates” at the bottom of the settings page!

---

## Detailed changes

### Features

* [Add “Unlisted” as a post visibility option](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/enable-unlisted)
  ([Pull request](https://github.com/mastodon/mastodon-android/pull/103))
* [Add “Federation” tab and change Discover tab order](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/add-federated-timeline) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/8))
* [Add image description button and viewer](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/display-alt-text) ([Pull request](https://github.com/mastodon/mastodon-android/pull/129))
* [Implement pinning posts and displaying pinned posts](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/pin-posts) ([Pull request](https://github.com/mastodon/mastodon-android/pull/140))
* [Implement deleting and re-drafting](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/delete-redraft) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/21))
* [Implement a bookmark button and list](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/bookmarks) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/22))
* [Add “Check for update” button in addition to integrated update checker](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/check-for-update-button)
* [Add “Mark media as sensitive” option](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/mark-media-as-sensitive)
* [Add settings to hide replies and reposts from the timeline](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/filter-home-timeline) ([Pull request](https://github.com/mastodon/mastodon-android/pull/317))
* [Follow and unfollow hashtags](https://github.com/sk22/mastodos/commit/7d38f031f197aa6cefaf53e39d929538689c1e4e) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/233))
* [Notification bell for posts](https://github.com/sk22/mastodos/commit/b166ca705eb9169025ef32bbe6315b42491b57ea) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/81))
* [Viewing lists and adding/removing users from lists](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:list-timeline-views) based on [@obstsalatschuessel](https://github.com/obstsalatschuessel)'s [Pull request](https://github.com/mastodon/mastodon-android/pull/286)
* [List favorited posts](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/favs-list)
* [Accept/reject follow requests](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/follow-requests)
* [Display content warning title above text](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/cw-above-text)
* [Add notifications tab for posts](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/posts-notifications-tab)
* [Show visibility of original post when replying](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/display-reply-visibility)
* [Improvements to the true black mode](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:true-black-improvements)

### Behavior

* [Make back button return to the home tab before exiting the app](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/back-returns-home) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/118))
* [Always preserve content warnings when replying](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/always-preserve-cw) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/113))
* [Display full image when adding image description](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/compose-image-description-full-image) ([Pull request](https://github.com/mastodon/mastodon-android/pull/182))
* [Set spoiler height independently to content height](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:spoiler-height-independent) ([Closes issue](https://github.com/mastodon/mastodon-android/issues/166))
* [Custom extended footer redesign](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:compact-extended-footer)
* [Option to hide interaction numbers](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:settings/hide-interaction-numbers)
* [Option to always reveal content warnings](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:feature/cw-above-text)
* [Option to disable scrolling title bars](https://github.com/mastodon/mastodon-android/compare/master...sk22:mastodos:settings/disable-marquee)

### Branding

* App name “Mastodos”
* Pink primary color
* Custom icon: Modulate upstream icon using ImageMagick
  ```bash
  mogrify -modulate 90,100,140 mastodon/src/main/res/mipmap-*/ic_launcher*.png
  ```

## Building

As this app is using Java 17 features, you need JDK 17 or newer to build it. Other than that, everything is pretty standard. You can either import the project into Android Studio and build it from there, or run the following command in the project directory:

```
./gradlew assembleRelease
```

## License

This project is released under the [GPL-3 License](./LICENSE).
