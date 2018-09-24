package com.generalscan.activity.bluetoothConnect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.generalscan.SendConstant;
import com.generalscan.bluetooth.BluetoothSend;
import com.generalscan.sdk.R;

/**
 * 发送数据列表
 * 
 * @author Administrator
 * 
 */
public class BluetoothSendList {

	// 所有的发送内容
	// All send
	private final int[] AllConstant = {
			// SendConstant.ListRead显示可以读取扫描器内容的列表
			// SendConstant.ListFunction 显示扫面器功能的列表
			// SendConstant.ListConfig 显示配置扫描器的列表
			// 目前有这3种列表，对应不同的功能
			// There are three type constants
			SendConstant.ListFunction,
			SendConstant.ListConfig,
			SendConstant.ListRead };

	private Context myContext;

	public BluetoothSendList(Context context) {
		myContext = context;
	}

	/**
	 * 显示所有发送数据的对话框 Display Dialog of send data
	 */
	public void ShowoDialog() {

		// 对应发送内容的描述
		// The corresponding transmitting content description Соответствующее описание содержимого передачи
		CharSequence[] items = { myContext.getString(R.string.Function),
				myContext.getString(R.string.Config),
				myContext.getString(R.string.Read) };

		AlertDialog.Builder builer = new AlertDialog.Builder(myContext);
		builer.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						// 发送对应内容
						// Send content
						BluetoothSend
								.SendContent(myContext, AllConstant[which]);
						// Этот метод имеет 4 параметра

// Первый - это контекст, второй - индекс содержимого для
// Отправить

// Третий - это список имен (не обязательно)
// BluetoothSend.SendContent (myContext, AllConstant [who], "自 定义 列表 名称");)
// Четвертый - это отображение по умолчанию отправки
// (по умолчанию не отображается, а не обязательно)
// BluetoothSend.SendContent (myContext, AllConstant [who], "自 定义 列表 名称", true);
						dialog.cancel();
					}

				});
		builer.create().show();
	}
}
