using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Obstacles : MonoBehaviour {

	void OnCollisionEnter2D(Collision2D c) {
		if (c.collider.tag == "Player") {
			c.transform.GetComponent<GameHandler>().SubtractHealth();
			Destroy(gameObject);
		}
	}

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
