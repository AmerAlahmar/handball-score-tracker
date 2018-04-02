package com.testspace.amer.handballscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ///////////////////Declaring Views And Variables/////////////////////
/////////////////////////////View//////////////////////////////////
    LinearLayout welcomeLinearLayout, mainScoreLinearLayout, winnerLinearLayout;

    TextView team1NameTextView, team2NameTextView,
            team1TotalScoreTextView, team2TotalScoreTextView,
            team1PenaltyScoreTextView, team2PenaltyScoreTextView,
            team1FoulsTextView, team2FoulsTextView,
            winnerTeamTextView, winnerPhraseTextView;
    Button startTheGameButton,
            teamAPlus1ScoreButton, teamBPlus1ScoreButton,
            teamAPlus1PenaltyScoreButton, teamBPlus1PenaltyScoreButton,
            teamAPlus1FoulButton, teamBPlus1FoulButton,
            teamAMinus1ScoreButton, teamBMinus1ScoreButton,
            teamAMinus1PenaltyScoreButton, teamBMinus1PenaltyScoreButton,
            teamAMinus1FoulButton, teamBMinus1FoulButton,
            endGameButton, resetScoreButton,
            restartAppButton;
    EditText team1NameEditText, team2NameEditText;
    ///////////////////////Variables////////////////////////////////////
    String team1Name = "", team2Name = "", drawPhrase = "DRAW", winnerTeamOriginal = "Winner Team", winnerPhraseOriginal = "Is The Winner  !";
    int team1TotalScore = 0, team2TotalScore = 0,
            team1PenaltyScore = 0, team2PenaltyScore = 0,
            team1Fouls = 0, team2Fouls = 0;
///////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////Connecting View with ids///////////////////////////////////
        ///////////////////////////////////////LayOuts///////////////////////////////////////////
        welcomeLinearLayout = findViewById(R.id.welcomeLinearLayout);
        mainScoreLinearLayout = findViewById(R.id.mainScoreLinearLayout);
        winnerLinearLayout = findViewById(R.id.winnerLinearLayout);
        /////////////////////////////////////Text Views//////////////////////////////////////////
        team1NameTextView = findViewById(R.id.team1NameTextView);
        team2NameTextView = findViewById(R.id.team2NameTextView);
        team1TotalScoreTextView = findViewById(R.id.team1TotalScoreTextView);
        team2TotalScoreTextView = findViewById(R.id.team2TotalScoreTextView);
        team1PenaltyScoreTextView = findViewById(R.id.team1PenaltyScoreTextView);
        team2PenaltyScoreTextView = findViewById(R.id.team2PenaltyScoreTextView);
        team1FoulsTextView = findViewById(R.id.team1FoulsTextView);
        team2FoulsTextView = findViewById(R.id.team2FoulsTextView);
        winnerTeamTextView = findViewById(R.id.winnerTeamTextView);
        winnerPhraseTextView = findViewById(R.id.winnerPhraseTextView);
        //////////////////////////////////////Buttons////////////////////////////////////////////
        startTheGameButton = findViewById(R.id.startTheGameButton);
        teamAPlus1ScoreButton = findViewById(R.id.teamAPlus1ScoreButton);
        teamBPlus1ScoreButton = findViewById(R.id.teamBPlus1ScoreButton);
        teamAPlus1PenaltyScoreButton = findViewById(R.id.teamAPlus1PenaltyScoreButton);
        teamBPlus1PenaltyScoreButton = findViewById(R.id.teamBPlus1PenaltyScoreButton);
        teamAPlus1FoulButton = findViewById(R.id.teamAPlus1FoulButton);
        teamBPlus1FoulButton = findViewById(R.id.teamBPlus1FoulButton);
        teamAMinus1ScoreButton = findViewById(R.id.teamAMinus1ScoreButton);
        teamBMinus1ScoreButton = findViewById(R.id.teamBMinus1ScoreButton);
        teamAMinus1PenaltyScoreButton = findViewById(R.id.teamAMinus1PenaltyScoreButton);
        teamBMinus1PenaltyScoreButton = findViewById(R.id.teamBMinus1PenaltyScoreButton);
        teamAMinus1FoulButton = findViewById(R.id.teamAMinus1FoulButton);
        teamBMinus1FoulButton = findViewById(R.id.teamBMinus1FoulButton);
        endGameButton = findViewById(R.id.endGameButton);
        resetScoreButton = findViewById(R.id.resetScoreButton);
        restartAppButton = findViewById(R.id.restartAppButton);
        /////////////////////////////////////Edit Text///////////////////////////////////////////
        team1NameEditText = findViewById(R.id.team1NameEditText);
        team2NameEditText = findViewById(R.id.team2NameEditText);
        /////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////Initialise VISIBILITY////////////////////////////////////////
        welcomeLinearLayout.setVisibility(View.VISIBLE);
        mainScoreLinearLayout.setVisibility(View.GONE);
        winnerLinearLayout.setVisibility(View.GONE);
        team1NameEditText.requestFocus();
        /////////////////////////////////////////////////////////////////////////////////////////
        //>>>>>/////////////////Listener of startTheGameButton/////////////////////<<<<<//
        startTheGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditTextEmpty(team1NameEditText)) {
                    team1NameEditText.setError("This field can't be empty");
                    team1NameEditText.requestFocus();
                } else if (isEditTextEmpty(team2NameEditText)) {
                    team2NameEditText.setError("This field can't be empty");
                    team2NameEditText.requestFocus();
                } else {
                    /////////Initialise Teams Names and switching Layouts////////////
                    team1Name = team1NameEditText.getText().toString();
                    team2Name = team2NameEditText.getText().toString();
                    team1NameTextView.setText(team1Name);
                    team2NameTextView.setText(team2Name);
                    welcomeLinearLayout.setVisibility(View.GONE);
                    mainScoreLinearLayout.setVisibility(View.VISIBLE);
                    winnerLinearLayout.setVisibility(View.GONE);
                    /////////////////////////////////////////////////////////////////
                }
            }
        });
        //>>>>>//////////////////////////////////////////////////////////////////////<<<<<//
        //>>>>>//////////Listeners of mainScoreLinearLayOut Buttons/////////////////<<<<<//
        //////////////////////Listener of team-X-Plus1ScoreButton///////////////////////////
        teamAPlus1ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1TotalScore++;
                team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBPlus1ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2TotalScore++;
                team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        //////////////////Listener of team-X-Plus1PenaltyScoreButton////////////////////////
        teamAPlus1PenaltyScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1TotalScore++;
                team1PenaltyScore++;
                team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
                team1PenaltyScoreTextView.setText(String.valueOf(team1PenaltyScore));
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBPlus1PenaltyScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2TotalScore++;
                team2PenaltyScore++;
                team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
                team2PenaltyScoreTextView.setText(String.valueOf(team2PenaltyScore));
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        //////////////////////Listener of team-X-Plus1FoulButton////////////////////////////
        teamAPlus1FoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1Fouls++;
                team1FoulsTextView.setText(String.valueOf(team1Fouls));
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBPlus1FoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2Fouls++;
                team2FoulsTextView.setText(String.valueOf(team2Fouls));
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////Listener of team-X-Minus1ScoreButton///////////////////////////
        teamAMinus1ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team1TotalScore > 0) {
                    team1TotalScore--;
                    team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
                }
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBMinus1ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team2TotalScore > 0) {
                    team2TotalScore--;
                    team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////Listener of team-X-Minus1PenaltyScoreButton///////////////////////
        teamAMinus1PenaltyScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team1TotalScore > 0 && team1PenaltyScore > 0) {
                    team1TotalScore--;
                    team1PenaltyScore--;
                    team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
                    team1PenaltyScoreTextView.setText(String.valueOf(team1PenaltyScore));
                }
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBMinus1PenaltyScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team2TotalScore > 0 && team2PenaltyScore > 0) {
                    team2TotalScore--;
                    team2PenaltyScore--;
                    team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
                    team2PenaltyScoreTextView.setText(String.valueOf(team2PenaltyScore));
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////Listener of team-X-Minus1FoulButton///////////////////////////
        teamAMinus1FoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team1Fouls > 0) {
                    team1Fouls--;
                    team1FoulsTextView.setText(String.valueOf(team1Fouls));
                }
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        teamBMinus1FoulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (team2Fouls > 0) {
                    team2Fouls--;
                    team2FoulsTextView.setText(String.valueOf(team2Fouls));
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////Listener of Reset And End game Buttons//////////////////////////
        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1TotalScore = 0;
                team2TotalScore = 0;
                team1PenaltyScore = 0;
                team2PenaltyScore = 0;
                team1Fouls = 0;
                team2Fouls = 0;

                team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
                team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
                team1PenaltyScoreTextView.setText(String.valueOf(team1PenaltyScore));
                team2PenaltyScoreTextView.setText(String.valueOf(team2PenaltyScore));
                team1FoulsTextView.setText(String.valueOf(team1Fouls));
                team2FoulsTextView.setText(String.valueOf(team2Fouls));

                Toast.makeText(MainActivity.this, "Game Restarted", Toast.LENGTH_LONG).show();
            }
        });
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
        endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////Initialise winner Name and switching Layouts////////////
                if (team1TotalScore > team2TotalScore) {
                    winnerTeamTextView.setText(team1Name);
                } else if (team2TotalScore > team1TotalScore) {
                    winnerTeamTextView.setText(team2Name);
                } else {
                    winnerPhraseTextView.setVisibility(View.GONE);
                    winnerTeamTextView.setText(drawPhrase);
                }
                welcomeLinearLayout.setVisibility(View.GONE);
                mainScoreLinearLayout.setVisibility(View.GONE);
                winnerLinearLayout.setVisibility(View.VISIBLE);
            }
            //////////////////////////////////////////////////////////////////////
        });
        ////////////////////////////////////////////////////////////////////////////////////
        //>>>>>//////////////////////////////////////////////////////////////////////<<<<<//
        //>>>>>//////////////Listener of winnerLinearLayout Button//////////////////<<<<<//
        restartAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////Resetting all values and views and switching Layouts////////////
                team1TotalScore = 0;
                team2TotalScore = 0;
                team1PenaltyScore = 0;
                team2PenaltyScore = 0;
                team1Fouls = 0;
                team2Fouls = 0;

                team1Name = "Team A";
                team1Name = "Team B";

                team1TotalScoreTextView.setText(String.valueOf(team1TotalScore));
                team2TotalScoreTextView.setText(String.valueOf(team2TotalScore));
                team1PenaltyScoreTextView.setText(String.valueOf(team1PenaltyScore));
                team2PenaltyScoreTextView.setText(String.valueOf(team2PenaltyScore));
                team1FoulsTextView.setText(String.valueOf(team1Fouls));
                team2FoulsTextView.setText(String.valueOf(team2Fouls));
                team1NameTextView.setText(team1Name);
                team2NameTextView.setText(team2Name);
                winnerTeamTextView.setText(winnerTeamOriginal);
                winnerPhraseTextView.setText(winnerPhraseOriginal);

                winnerPhraseTextView.setVisibility(View.VISIBLE);
                welcomeLinearLayout.setVisibility(View.VISIBLE);
                mainScoreLinearLayout.setVisibility(View.GONE);
                winnerLinearLayout.setVisibility(View.GONE);
                //////////////////////////////////////////////////////////////////////////

            }
        });
        //>>>>>//////////////////////////////////////////////////////////////////////<<<<<//


    }

    private boolean isEditTextEmpty(EditText editText) {
        String text = editText.getText().toString();
        return text.isEmpty();
    }

}