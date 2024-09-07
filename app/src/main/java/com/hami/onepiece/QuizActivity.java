package com.hami.onepiece;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    // UI Elements
    private TextView questionTextView;
    private CheckBox option1, option2, option3, option4;
    private Button nextButton, backButton;
    private LinearLayout optionsLayout;
    private MediaPlayer mediaPlayer;

    // Data for Quiz
    private String[] questions = {
            "Who is the main protagonist of One Piece?",
            "What is the name of Luffy's pirate crew?",
            "Who is the first member to join Luffy’s crew?",
            "What is Luffy's devil fruit called?",
            "Who is the captain of the Red-Haired Pirates?",
            "What is the name of the world’s strongest swordsman?",
            "What is Nami’s primary role in the Straw Hat Pirates?",
            "Who gave Luffy his signature straw hat?",
            "What is the name of Sanji's fighting style?",
            "What is Tony Tony Chopper's devil fruit?",
            "Who is the shipwright of the Straw Hat Pirates?",
            "What island is known as the home of the revolutionary army?",
            "What is the name of Zoro’s signature sword?",
            "Who was Ace’s biological father?",
            "What is Nico Robin’s dream?",
            "What sea is the birthplace of Luffy, Zoro, and Sanji?",
            "Which one of these characters can control sand?",
            "Who is the current Fleet Admiral of the Marines after the time skip?",
            "What is the name of the legendary treasure everyone is searching for?",
            "Who is the swordsman that fights with three swords?"
    };

    private String[][] options = {
            {"Zoro", "Luffy", "Sanji", "Usopp"},
            {"Red-Haired Pirates", "Whitebeard Pirates", "Straw Hat Pirates", "Blackbeard Pirates"},
            {"Nami", "Sanji", "Usopp", "Zoro"},
            {"Gomu Gomu no Mi", "Suna Suna no Mi", "Mera Mera no Mi", "Hie Hie no Mi"},
            {"Shanks", "Kaido", "Big Mom", "Teach"},
            {"Dracule Mihawk", "Roronoa Zoro", "Shanks", "Silvers Rayleigh"},
            {"Doctor", "Navigator", "Chef", "Swordsman"},
            {"Gol D. Roger", "Shanks", "Zoro", "Ace"},
            {"Fishman Karate", "Rokushiki", "Black Leg", "Electro"},
            {"Hito Hito no Mi", "Gomu Gomu no Mi", "Tori Tori no Mi", "Ushi Ushi no Mi"},
            {"Brook", "Franky", "Robin", "Jinbei"},
            {"Dressrosa", "Alabasta", "Baltigo", "Zou"},
            {"Shusui", "Yoru", "Enma", "Wado Ichimonji"},
            {"Gol D. Roger", "Monkey D. Dragon", "Edward Newgate", "Silvers Rayleigh"},
            {"To become Pirate King", "To find the All Blue", "To uncover the Rio Poneglyph", "To defeat Mihawk"},
            {"North Blue", "East Blue", "West Blue", "South Blue"},
            {"Crocodile", "Doflamingo", "Enel", "Magellan"},
            {"Sengoku", "Akainu", "Aokiji", "Kizaru"},
            {"Davy Jones’ Locker", "Eternal Pose", "Poneglyph", "One Piece"},
            {"Zoro", "Mihawk", "Brook", "Cavendish"}
    };

    private int[] correctAnswers = {
            1,  // Luffy
            2,  // Straw Hat Pirates
            3,  // Zoro
            0,  // Gomu Gomu no Mi
            0,  // Shanks
            0,  // Dracule Mihawk
            1,  // Navigator
            1,  // Shanks
            2,  // Black Leg
            0,  // Hito Hito no Mi
            1,  // Franky
            2,  // Baltigo
            3,  // Wado Ichimonji
            0,  // Gol D. Roger
            2,  // To uncover the Rio Poneglyph
            1,  // East Blue
            0,  // Crocodile
            1,  // Akainu
            3,  // One Piece
            0   // Zoro
    };
    private int currentQuestion = 0;
    private int score = 0;

    private int[] imageResources = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        optionsLayout = findViewById(R.id.optionsLayout);
        mediaPlayer = MediaPlayer.create(this, R.raw.soundtrack);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        // Load the first question
        loadQuestion();

        // Handle Next Button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(); // Check the current answer
                if (currentQuestion < questions.length - 1) {
                    currentQuestion++;
                    loadQuestion();
                } else {
                    showScoreDialog(); // Show score at the end of the quiz
                }
            }
        });

        // Handle Back Button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    loadQuestion();
                }
            }
        });
    }

    // Load the current question and options
    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);

        // Clear any previous selections
        option1.setChecked(false);
        option2.setChecked(false);
        option3.setChecked(false);
        option4.setChecked(false);

        // Set a random background image
        Random random = new Random();
        int randomImage = imageResources[random.nextInt(imageResources.length)];
        optionsLayout.setBackgroundResource(randomImage);
    }

    // Check the selected answer
    private void checkAnswer() {
        int selectedAnswer = -1;
        if (option1.isChecked()) selectedAnswer = 0;
        if (option2.isChecked()) selectedAnswer = 1;
        if (option3.isChecked()) selectedAnswer = 2;
        if (option4.isChecked()) selectedAnswer = 3;

        if (selectedAnswer == correctAnswers[currentQuestion]) {
            score += 5; // Correct answer
        } else if (selectedAnswer != -1) {
            score -= 1; // Wrong answer
        }
    }

    // Show the score in a dialog box
    private void showScoreDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setTitle("Quiz Completed");
        builder.setMessage("Your Score: " + score);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish(); // End the activity
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
