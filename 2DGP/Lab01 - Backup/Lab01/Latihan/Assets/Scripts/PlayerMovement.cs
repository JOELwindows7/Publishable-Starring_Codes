using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour {

	public float speed = 10.0f;
	private float leftWall = -4f;
	private float rightWall = 4f;
	private Animator anim;

	// Use this for initialization
	void Start () {
		anim = GetComponent<Animator> ();
	}
	
	// Update is called once per frame
	void Update () {
		float translation = Input.GetAxis ("Horizontal") * speed * Time.deltaTime;

		if (translation > 0) {
			transform.localScale = new Vector3 (2, 2, 2);
		} else if (translation < 0) {
			transform.localScale = new Vector3 (-2, 2, 2);
		}

		if (transform.position.x + translation < rightWall &&
		    transform.position.x + translation > leftWall)
			transform.Translate (translation, 0, 0);

		if (translation != 0) {
			anim.SetFloat ("PlayerSpeed", speed);
		} else {
			anim.SetFloat ("PlayerSpeed", 0);
		}
			
	}
}
