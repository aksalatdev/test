    package com.example.accelorometer

    import android.content.Context
    import android.hardware.Sensor
    import android.hardware.SensorEvent
    import android.hardware.SensorEventListener
    import android.hardware.SensorManager
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import kotlinx.android.synthetic.main.activity_main.*

    private var sensorManager: SensorManager? = null


    class MainActivity : AppCompatActivity(), SensorEventListener {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        }



        override fun onSensorChanged(event: SensorEvent?) {
           if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
               sumbuX.text = "sumbu X : "+event.values[0].toString()
               sumbuY.text = "sumbu Y :"+event.values[1].toString()
               sumbuZ.text = "sumbu Z :"+event.values[2].toString()
           }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

        override fun onResume() {
            super.onResume()
            sensorManager!!.registerListener(this, sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        }

        override fun onPause() {
            super.onPause()
            sensorManager!!.unregisterListener(this)
        }

    }