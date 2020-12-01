package com.peakfinn.madlevel5example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_reminder_fragment.*
import androidx.fragment.app.viewModels

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddReminderFragment : Fragment() {

    private val viewModel: ReminderViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_reminder_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddReminder.setOnClickListener {
            onAddReminder()
        }
    }

    private fun onAddReminder() {
        val reminderText = etReminderName.text.toString()

        if (reminderText.isNotBlank()) {
            viewModel.insertReminder(Reminder(reminderText))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the RemindersFragment
            findNavController().popBackStack()

        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_reminder, Toast.LENGTH_SHORT
            ).show()
        }
    }

}