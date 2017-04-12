package com.dexposedart.newhook.TestHook;

import android.view.View;
import android.widget.Toast;

import com.dexposedart.newhook.App;
import com.taobao.android.dexposed.XC_MethodReplacement;
import com.taobao.android.dexposed.annotations.Hook;
import com.taobao.android.dexposed.annotations.HookMethod;
import com.taobao.android.dexposed.annotations.OriginalHookMethod;


/**
 * 作者：zhangzhongping on 17/4/3 23:29
 * 邮箱：android_dy@163.com
 */
@Hook(Class = "com.dexposedart.newhook.MainActivity",
        Name = "Toasts", Type = {String.class, Boolean[].class, String.class, View[].class})
public class TestProxy1 extends XC_MethodReplacement {

    @HookMethod(MethodName = "HookMethods")
    public static Object HookMethods(Boolean[] booleen, String msg, View[] view) {
        Toast.makeText(App.getContext(), msg + "->Hook", 0).show();
        return OriginalHookMethods(booleen, msg, view) + "Hook";
    }

    @OriginalHookMethod(MethodName = "OriginalHookMethods")
    public static Object OriginalHookMethods(Boolean[] booleen, String msg, View[] view) {
        return new Object();
    }

    @Override
    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
        return HookMethods((Boolean[]) param.args[0], (String) param.args[1], (View[]) param.args[2]);
    }
}
