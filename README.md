# One Piece Quiz App

## Overview

The One Piece Quiz App is an Android application designed to test your knowledge about the popular anime "One Piece." The app features an engaging quiz experience with multiple-choice questions, score tracking, and dynamic backgrounds. 

## Features

### 1. Main Activity

- **Media Playback:** Plays background music (`soundtrack`) on launch. The music pauses when the app is not in focus and resumes when the app is back in focus.
- **Play Button:** Navigates to the Quiz Activity.

### 2. Quiz Activity

- **Dynamic Background:** Changes background images randomly (`image1`, `image2`, etc.) on navigating between questions.
- **Question Display:** Shows questions related to "One Piece" in a `TextView`.
- **Options:** Displays multiple-choice options in a `LinearLayout` with rounded rectangular backgrounds and black shadows.
- **Score Tracking:** Updates score based on correct (+5) and incorrect (-1) answers.
- **Navigation Buttons:**
  - **Back Button:** Allows the user to go to the previous question.
  - **Next Button:** Moves to the next question and displays the final score in a dialog box upon reaching the last question.
- **Score Display:** Shows final score in a dialog box when the user presses the Next button on the last question.

### 3. App Bar Management

- **No App Bar:** Removes the default app bar from both Main and Quiz Activities to provide a cleaner UI.

### 4. Icon Management

- **Launcher Icon:** Customizable through the `mipmap` directory.
- **In-App Icons:** Customizable through the `drawable` directory for various UI elements.

### 5. UI Elements

- **CheckBox Styling:** Checkboxes have a white rounded rectangular background with a black shadow on the left and bottom.
- **Button Styling:** Buttons have a white background with black text and include icons (back arrow and next arrow) for navigation.

### 6. Additional Notes

- **Media Player Management:** Ensures proper handling of the media player lifecycle.
- **Dynamic Image Changes:** Background images change randomly to enhance user experience.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Hami0095/demo-gym-website.git
   ```

2. Open the project in Android Studio.

3. Build and run the application on an emulator or physical device.

## Contributing

Feel free to open issues or submit pull requests to contribute to the project.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

