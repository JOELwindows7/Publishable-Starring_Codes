using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
//using UnityEngine.timer;

public class Reload : MonoBehaviour {
    public const float TIME_LIMIT = 5f;
    private float timer = 0.0f;

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        this.timer += Time.deltaTime;
        if(this.timer >= TIME_LIMIT)
        {
            SceneManager.LoadScene("Scene00");
        }
	}
}
