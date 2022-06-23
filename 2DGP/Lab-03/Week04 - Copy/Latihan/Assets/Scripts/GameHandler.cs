using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameHandler : MonoBehaviour {

	//Variable Value
	public float health = 2;
	public float score = 0;

	//Check if win
	public bool gameover = false;

	//Reference our UI elements
	public UnityEngine.UI.Text healthUI;
	public UnityEngine.UI.Text ScoreUI;
	public GameObject gameOverUI;
	public GameObject youWinUI;

	public void StopGame() {
		gameover = true;
		gameObject.SetActive(false);
	}

	public void AddScore() {
		score += 10;
		ScoreUI.text = score.ToString();
        if(score > PlayerPrefs.GetInt("highScore", 0))
        {
            PlayerPrefs.SetInt("highScore", (int) score);
        }
	}

	public void SubtractHealth() {

		health -= 1;
		healthUI.text = health.ToString();
		if (health == 0) {
			gameOverUI.SetActive(true);
            Debug.Log("GameOver");
            //PlayerPrefs.Save();
			StopGame();
		}
	}

	void OnTriggerEnter2D(Collider2D c) {

        //info
		if (c.name == "coin") {
			AddScore();
			Destroy(c.gameObject);
            Debug.Log("Koin");
		}
		else if (c.tag == "Water") {
			health = 0;
			healthUI.text = health.ToString();
			gameOverUI.SetActive(true);
            Debug.Log("Air");
            //PlayerPrefs.Save();
            StopGame();
		}
		else if (c.tag == "Ending") {
			youWinUI.SetActive(true);
            Debug.Log("Ending");
            //PlayerPrefs.Save();
            StopGame();
		}
	}

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
