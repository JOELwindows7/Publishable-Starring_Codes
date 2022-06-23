using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameStart : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (Input.anyKey && !Input.GetKeyDown(KeyCode.Escape)) //don't use anykey at all. any key is mostly not good! you must also consider other keys as well.
        {
            SceneManager.LoadScene("Scene01");
            

            //can only load scene on the "Scene in the Build"!!!
        } else if (!Input.anyKey && Input.GetKeyDown(KeyCode.Escape))
        {
            Application.Quit();
        }
	}
}
