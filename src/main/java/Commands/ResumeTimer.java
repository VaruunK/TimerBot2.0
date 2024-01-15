package Commands;

import Main.TimerO;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ResumeTimer extends ListenerAdapter {
    TimerO timerO = TimerO.getTimer();
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("resumetimer")) {
            if(!timerO.getIsSet()){
                event.reply("The timer has not been set");
            } else if(!timerO.getIsStarted()){
                event.reply("The timer has not been started");
            } else if(!timerO.getIsPaused()){
                event.reply("The timer has not been paused");
            } else if(timerO.getIsStopped()) {
                event.reply("The timer has been stopped");
            } else {
                timerO.getWatch().stop();
                timerO.setTimePaused(timerO.getWatch().getTime());
                timerO.schedule(StartTimer.task, );
            }
        }
    }
}
