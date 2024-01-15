package Commands;

import Main.TimerO;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.TimerTask;

public class StartTimer extends ListenerAdapter {
    public static TimerTask task;
    private OptionMapping mention;
    TimerO timerO = TimerO.getTimer();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("starttimer")) {
            if (!timerO.getIsSet()) {
                event.reply("The timer has not been set");
            } else if (timerO.getIsStarted()) {
                event.reply("The timer is already started");
            } else if (timerO.getIsPaused()) {
                event.reply("The timer is paused");
            } else if (timerO.getIsStopped()) {
                event.reply("The timer is stopped");
            } else {

                mention = event.getOption("mention");

                task = new TimerTask() {
                    @Override
                    public void run() {
                        if (mention != null) {
                            String mentionS = mention.getAsRole().getAsMention();
                            event.getChannel().sendMessage(mentionS + " timer has ended");
                        } else {
                            event.getChannel().sendMessage(event.getUser().getAsMention() + " timer has ended");
                        }
                    }
                };
                timerO.setStartTime(System.currentTimeMillis());
                timerO.schedule(task, timerO.getTimerLength());

                //math for converting length of timer to seconds, minutes, and hours
                int timeTotalSeconds = timerO.getTimerLength() / (1000);
                int seconds = timeTotalSeconds % (60);
                int minutes = (timeTotalSeconds / 60) % 60;
                int hours = (timeTotalSeconds / 3600);

                event.reply("Timer Started For:\n" + hours + " hours\n" + minutes + " minutes\n" + seconds + " seconds").queue();
            }
        }
    }
}
