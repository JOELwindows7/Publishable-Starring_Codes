using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyScript : MonoBehaviour {

    public float speed = 1;
    Vector2 currVelocity;
    Vector3 curScale;

	// Use this for initialization
	void Start () {
        GetComponent<Rigidbody2D>().velocity = new Vector2(-1 * speed, 0);
	}
	
	// Update is called once per frame
	void Update () {
        currVelocity = GetComponent<Rigidbody2D>().velocity;

        if(currVelocity.x == 0)
        {
            transform.position = new Vector2(transform.position.x, transform.position.y + .01f); //y is little bit up
            GetComponent<Rigidbody2D>().velocity = new Vector2(curScale.x > 0 ? -1 : 1 * speed, 0);
        }

    }

    void OnTriggerEnter2D(Collider2D c)
    {
        if(c.tag == "Obstacle")
        {
            GetComponent<Rigidbody2D>().velocity = new Vector2(-1 * currVelocity.x, 0);
            curScale = transform.localScale;
            curScale.x *= -1;
            transform.localScale = curScale;
        } else if (c.name == "GroundCheck")
        {
            print("Killed by stomp!");
            Destroy(gameObject);
        }
    }

    void OnCollisionEnter2D(Collision2D c)
    {
        if(c.collider.tag == "Player")
        {
            c.transform.GetComponent<GameHandler>().SubtractHealth();
        }
    }
    //Ciel Fledge
}
