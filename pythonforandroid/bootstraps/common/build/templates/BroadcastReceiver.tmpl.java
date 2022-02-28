package {{ args.package }};

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public class BroadcastReceiver{{ name|capitalize }} extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent service_intent = new Intent(context, Service{{ name|capitalize }}.class);
        String argument = context.getFilesDir().getAbsolutePath() + "/app";
        service_intent.putExtra("androidPrivate", context.getFilesDir().getAbsolutePath());
        service_intent.putExtra("androidArgument", argument);
        service_intent.putExtra("serviceTitle", "{{ args.name }}");
        service_intent.putExtra("serviceDescription", "{{ name|capitalize }}");
        service_intent.putExtra("serviceEntrypoint", "{{ entrypoint }}");
        service_intent.putExtra("pythonName", "{{ name }}");
        service_intent.putExtra("serviceStartAsForeground", "{{ foreground|lower }}");
        service_intent.putExtra("pythonHome", argument);
        service_intent.putExtra("pythonPath", argument + ":" + argument + "/lib");
        service_intent.putExtra("pythonServiceArgument", "");
        context.startService(service_intent);
    }
}