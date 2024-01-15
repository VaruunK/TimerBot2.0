package Commands;

import Main.TimerO;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.commons.lang3.time.StopWatch;

public class PauseTimer extends ListenerAdapter {
    TimerO timerO = TimerO.getTimer();
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("pausetimer")){
            if(!timerO.getIsSet()) {
                event.reply("The timer has not been set");
            } else if(!timerO.getIsStarted()){
                event.reply("The timer has not been started");
            } else if(timerO.getIsPaused()){
                event.reply("The timer is already paused");
            } else if(timerO.getIsStopped()){
                event.reply("The timer is stopped");
            } else {
                timerO.getWatch().start();
                timerO.cancel();
                timerO.setPaused(true);
                event.reply("Timer paused");
            }
        }
    }
}
