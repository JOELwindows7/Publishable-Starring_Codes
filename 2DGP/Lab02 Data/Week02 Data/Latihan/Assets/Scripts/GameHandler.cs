using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameHandler : MonoBehaviour {

    public float health = 2;
    public float score = 0;

    public bool gameover = false;

    public UnityEngine.UI.Text healthUI;
    public UnityEngine.UI.Text scoreUI;
    public GameObject gameOverUI;
    public GameObject youWinUI;

	// Use this for initialization
	void Start () {
        healthUI.text = health.ToString();
    }
	
	// Update is called once per frame
	void Update () {
		
	}

    public void StopGame()
    {
        gameover = true;
        gameObject.SetActive(false);
    }

    public void AddScore()
    {
        score += 10;
        scoreUI.text = score.ToString();
    }

    public void SubtractHealth()
    {
        health -= 1;
        healthUI.text = health.ToString();
        if(health == 0)
        {
            gameOverUI.SetActive(true);
            StopGame();
        }
    }

    void OnTriggerEnter2D(Collider2D c)
    {
        if (c.tag == "Coin")
        {
            AddScore();
            Destroy(c.gameObject);
        } else if(c.tag == "Water")
        {
            health = 0;
            gameOverUI.SetActive(true);
            StopGame();
        } else if(c.tag == "Ending")
        {
            youWinUI.SetActive(true);
            StopGame();
        }
    }
}
