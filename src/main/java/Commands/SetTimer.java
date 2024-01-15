package Commands;

import Main.TimerO;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class SetTimer extends ListenerAdapter {

    private OptionMapping hours;
    private OptionMapping minutes;
    private OptionMapping seconds;
    private int timerLength;

    TimerO timerO = TimerO.getTimer();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("settimer")) {
            hours = event.getOption("hours");
            minutes = event.getOption("minutes");
            seconds = event.getOption("seconds");

            if(hours != null && minutes != null && seconds != null){
                //converts given values into milliseconds
                timerLength = (((hours.getAsInt())*(3600 * 1000)) + ((minutes.getAsInt())*(60 * 1000)) + ((seconds.getAsInt())*1000));
                //checks if the timer is not set for 0 seconds
                if(timerLength == 0){
                    event.reply("You cannot have a time set for 0 seconds");
                }
                //returns values as ints
                event.reply("Timer Set For:\n" + hours.getAsInt() + " hours\n" + minutes.getAsInt() + " minutes\n" + seconds.getAsInt() + " seconds")
                        .queue();
                timerO.setTimerLength(timerLength);
                timerO.setSet(true);
            } else {
                event.reply("You must fill out all the options")
                        .queue();
            }
        }
    }
}
