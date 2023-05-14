package jp.techacademy.satoko.abiko.ui

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import jp.techacademy.satoko.abiko.ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
         //   val textView
            binding.textView.text = binding.editText.text.toString()
        } else if (v.id == R.id.button2) {
            showAlertDialog()
        } else if (v.id == R.id.button3) {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定")
        {dialog, which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立"){_,_ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定"){_,_ ->
            Log.d("UI_PARTS", "否定ボタン")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener {
                    view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }
}